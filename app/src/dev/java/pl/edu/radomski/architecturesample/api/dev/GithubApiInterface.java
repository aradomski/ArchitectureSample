package pl.edu.radomski.architecturesample.api.dev;

import java.util.List;

import pl.edu.radomski.architecturesample.api.dev.data.ApiRepos;
import pl.edu.radomski.architecturesample.api.dev.data.ApiUser;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubApiInterface {
    @GET("users/{userName}")
    Observable<ApiUser> user(@Path("userName") String userName);



    @GET("users/{userName}/repos")
    Observable<List<ApiRepos>> userRepos(@Path("userName") String userName);
}
