package radomski.edu.pl.architecturesample.api.dev;

import java.util.List;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.api.BaseApiClient;
import radomski.edu.pl.architecturesample.api.dev.data.ApiRepos;
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


    public Observable<List<ApiRepos>> userRepos(String userName) {
        return getApiWorker().userRepos(userName);
    }
}
