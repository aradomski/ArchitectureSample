package pl.edu.radomski.architecturesample;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder;
import com.facebook.stetho.timber.StethoTree;
import com.github.moduth.blockcanary.BlockCanary;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;

import io.palaima.debugdrawer.timber.data.LumberYard;
import pl.edu.radomski.architecturesample.api.utils.OkHttpProvider;
import pl.edu.radomski.architecturesample.utils.AppBlockCanaryContext;
import timber.log.Timber;

public class FlavouredApp extends SuperApp {
    @Override
    public void onCreate() {
        super.onCreate();


        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(() -> new Stetho.DefaultInspectorModulesBuilder(FlavouredApp.this)
                        .runtimeRepl(new JsRuntimeReplFactoryBuilder(FlavouredApp.this)
                                .addVariable("foo", "bar")
                                .build())
                        .finish())
                .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                .build());


        if (LeakCanary.isInAnalyzerProcess(this)) {
            // This process is dedicated to LeakCanary for heap analysis.
            // You should not init your app in this process.
            return;
        }
        LeakCanary.install(this);

        BlockCanary.install(this, new AppBlockCanaryContext()).start();

        LumberYard lumberYard = LumberYard.getInstance(this);
        lumberYard.cleanUp();
        Timber.plant(lumberYard.tree());
        Timber.plant(new Timber.DebugTree());
        Timber.plant(new StethoTree());

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(OkHttpProvider.provideOkHttp(this)))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
