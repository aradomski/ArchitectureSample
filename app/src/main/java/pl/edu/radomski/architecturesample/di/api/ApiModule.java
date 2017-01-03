package pl.edu.radomski.architecturesample.di.api;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import pl.edu.radomski.architecturesample.BuildConfig;
import pl.edu.radomski.architecturesample.api.utils.OkHttpProvider;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    public static final String NAMED_COUNTRY = "country";
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private final Gson gson;

    public ApiModule(Context context) {

        okHttpClient = OkHttpProvider.provideOkHttp(context);


        retrofit = new Retrofit.Builder()
                .baseUrl(BuildConfig.API_URL)
                .client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

        gson = new GsonBuilder()
                .create();

    }

    @Provides
    public OkHttpClient getOkHttpClient() {
        return okHttpClient;
    }

    @Provides
    public Gson getGson() {
        return gson;
    }

    @Provides
    public Retrofit getRetrofit(){return retrofit;}
}

