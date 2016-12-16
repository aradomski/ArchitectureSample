package pl.edu.radomski.architecturesample;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder;
import com.facebook.stetho.timber.StethoTree;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.leakcanary.LeakCanary;
import com.squareup.picasso.Picasso;

import pl.edu.radomski.architecturesample.api.utils.OkHttpProvider;
import timber.log.Timber;

public class SuperApp extends Application {


    @Override
    public void onCreate() {
        super.onCreate();

        Stetho.initialize(Stetho.newInitializerBuilder(this)
                .enableWebKitInspector(() -> new Stetho.DefaultInspectorModulesBuilder(SuperApp.this)
                        .runtimeRepl(new JsRuntimeReplFactoryBuilder(SuperApp.this)
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

        Timber.plant(new Timber.DebugTree());
        Timber.plant(new StethoTree());

        Picasso picasso = new Picasso.Builder(this)
                .downloader(new OkHttp3Downloader(OkHttpProvider.provideOkHttp()))
                .build();
        Picasso.setSingletonInstance(picasso);
    }
}
