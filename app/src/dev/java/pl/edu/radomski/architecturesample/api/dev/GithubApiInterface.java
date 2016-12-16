package pl.edu.radomski.architecturesample.api.dev;

import java.util.List;

import pl.edu.radomski.architecturesample.api.dev.data.ApiFollower;
import pl.edu.radomski.architecturesample.api.dev.data.ApiRepos;
import pl.edu.radomski.architecturesample.api.dev.data.ApiUser;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubApiInterface {
    @Headers("Connection: close")
    @GET("users/{userName}")
    Observable<ApiUser> user(@Path("userName") String userName);

    @Headers("Connection: close")
    @GET("users/{userName}/repos")
    Observable<List<ApiRepos>> userRepos(@Path("userName") String userName);

    @Headers("Connection: close")
    @GET("users/{userName}/followers")
    Observable<List<ApiFollower>> userFolowers(@Path("userName") String userName);
}
