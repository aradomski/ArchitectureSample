package radomski.edu.pl.architecturesample.api.dev;

import radomski.edu.pl.architecturesample.api.dev.data.ApiUser;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Observable;

public interface GithubApiInterface {
    @GET("users/{userName}")
    Observable<ApiUser> user(@Path("userName") String userName);
}
