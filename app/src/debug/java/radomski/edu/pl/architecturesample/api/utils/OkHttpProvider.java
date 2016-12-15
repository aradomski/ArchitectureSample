package radomski.edu.pl.architecturesample.api.utils;

import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import radomski.edu.pl.architecturesample.BuildConfig;

public class OkHttpProvider {
    private static OkHttpClient okHttpClient;

    @NonNull
    private static OkHttpClient.Builder getBuilder() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);
            builder.addInterceptor(logging);
            builder.addNetworkInterceptor(new StethoInterceptor());
        }
        return builder;
    }

    public static OkHttpClient provideOkHttp() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = getBuilder();
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
