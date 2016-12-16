package pl.edu.radomski.architecturesample.api.utils;

import android.support.annotation.NonNull;

import okhttp3.OkHttpClient;

public class OkHttpProvider {
    private static OkHttpClient okHttpClient;

    @NonNull
    private static OkHttpClient.Builder getBuilder() {
        return new OkHttpClient.Builder();
    }

    public static OkHttpClient provideOkHttp() {
        if (okHttpClient == null) {
            OkHttpClient.Builder builder = getBuilder();
            okHttpClient = builder.build();
        }
        return okHttpClient;
    }
}
