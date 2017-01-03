package pl.edu.radomski.architecturesample.api.utils;

import android.content.Context;
import android.support.annotation.NonNull;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import java.io.File;
import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

public class OkHttpProvider {
    private static OkHttpClient okHttpClient;
    private static final int DISK_CACHE_SIZE = 20 * 1024 * 1024; // 20 MB

    @NonNull
    private static OkHttpClient.Builder getBuilder(Context context) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        File cacheDir = new File(context.getCacheDir(), "okhttp3");
        Cache cache = new Cache(cacheDir, DISK_CACHE_SIZE);

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);
        builder.addInterceptor(logging);
        builder.addNetworkInterceptor(new StethoInterceptor());

        builder.cache(cache)
                .readTimeout(10, TimeUnit.SECONDS)
                .writeTimeout(10, TimeUnit.SECONDS)
                .connectTimeout(10, TimeUnit.SECONDS);

        return builder;
    }

    public static OkHttpClient provideOkHttp(Context context) {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = getBuilder(context);
            builder.retryOnConnectionFailure(false);
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
