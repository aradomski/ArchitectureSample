package pl.edu.radomski.architecturesample.api.dev;

import java.util.List;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.api.BaseApiClient;
import pl.edu.radomski.architecturesample.api.dev.data.ApiRepos;
import pl.edu.radomski.architecturesample.api.dev.data.ApiUser;
import pl.edu.radomski.architecturesample.di.api.ApiScope;
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
