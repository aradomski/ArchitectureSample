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
    }
}
