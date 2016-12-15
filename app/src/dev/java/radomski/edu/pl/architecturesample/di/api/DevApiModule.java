package radomski.edu.pl.architecturesample.di.api;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import radomski.edu.pl.architecturesample.api.dev.GithubApiInterface;
import radomski.edu.pl.architecturesample.api.utils.OkHttpProvider;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class DevApiModule extends ApiModule {
    private final OkHttpClient devOkHttpClient;
    private final Retrofit devRetrofit;

    public DevApiModule() {
        devOkHttpClient = OkHttpProvider.provideOkHttp();


        devRetrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .client(devOkHttpClient)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .build();

    }

    @Provides
    public GithubApiInterface getFeaturedApiInterface() {
        return devRetrofit.create(GithubApiInterface.class);
    }
}
