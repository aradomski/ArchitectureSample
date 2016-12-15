package radomski.edu.pl.architecturesample;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.facebook.stetho.rhino.JsRuntimeReplFactoryBuilder;
import com.squareup.leakcanary.LeakCanary;

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

    }
}
