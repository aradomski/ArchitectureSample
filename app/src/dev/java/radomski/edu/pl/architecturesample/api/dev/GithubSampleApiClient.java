package radomski.edu.pl.architecturesample.api.dev;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.api.BaseApiClient;
import radomski.edu.pl.architecturesample.api.dev.data.ApiUser;
import radomski.edu.pl.architecturesample.di.api.ApiScope;
import rx.Observable;

@ApiScope
public class GithubSampleApiClient extends BaseApiClient<GithubApiInterface> {
    @Inject
    public GithubSampleApiClient(GithubApiInterface githubApiInterface) {
        setApiWorker(githubApiInterface);
    }


    public Observable<ApiUser> user(String userName) {
        return getApiWorker().user(userName);
    }
}
