package radomski.edu.pl.architecturesample.repository.dev;

import java.util.List;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.api.dev.GithubSampleApiClient;
import radomski.edu.pl.architecturesample.api.dev.data.ApiRepos;
import radomski.edu.pl.architecturesample.api.dev.data.ApiUser;
import radomski.edu.pl.architecturesample.di.app.AppScope;
import radomski.edu.pl.architecturesample.utils.rx.cache.CacheHelper;
import radomski.edu.pl.architecturesample.utils.rx.cache.CacheWrapper;
import rx.Observable;
import rx.subjects.BehaviorSubject;

@AppScope
public class DevPlaygroundRepository {

    @Inject
    GithubSampleApiClient githubSampleApiClient;


    private BehaviorSubject<CacheWrapper<List<ApiRepos>>> reposCache = BehaviorSubject.create();

    @Inject
    public DevPlaygroundRepository() {
    }


    public Observable<ApiUser> user(String userName) {
        return githubSampleApiClient.user(userName);
    }

    public Observable<List<ApiRepos>> userRepos(String userName) {
        return CacheHelper.cachingCallWrap(reposCache, githubSampleApiClient.userRepos(userName));
    }

    public void invalidateCache() {
        if (reposCache.hasValue()) {
            reposCache.getValue().invalidate();
        }
    }
}
