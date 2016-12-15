package radomski.edu.pl.architecturesample.repository.dev;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.api.dev.GithubSampleApiClient;
import radomski.edu.pl.architecturesample.api.dev.data.ApiUser;
import radomski.edu.pl.architecturesample.di.app.AppScope;
import rx.Observable;

@AppScope
public class DevPlaygroundRepository {

    @Inject
    GithubSampleApiClient githubSampleApiClient;


    @Inject
    public DevPlaygroundRepository() {
    }


    public Observable<ApiUser> user(String userName) {
        return githubSampleApiClient.user(userName);
    }
}
