package radomski.edu.pl.architecturesample.di.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import radomski.edu.pl.architecturesample.BuildConfig;
import radomski.edu.pl.architecturesample.api.utils.OkHttpProvider;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {
    public static final String NAMED_COUNTRY = "country";
    private final OkHttpClient okHttpClient;
    private final Retrofit retrofit;
    private final Gson gson;

    public ApiModule() {

        okHttpClient = OkHttpProvider.provideOkHttp();


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

