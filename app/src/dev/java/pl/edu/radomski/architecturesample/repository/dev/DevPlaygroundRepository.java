package pl.edu.radomski.architecturesample.repository.dev;

import java.util.List;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.api.dev.GithubSampleApiClient;
import pl.edu.radomski.architecturesample.api.dev.data.ApiRepos;
import pl.edu.radomski.architecturesample.api.dev.data.ApiUser;
import pl.edu.radomski.architecturesample.di.app.AppScope;
import pl.edu.radomski.architecturesample.utils.rx.cache.CacheHelper;
import pl.edu.radomski.architecturesample.utils.rx.cache.CacheWrapper;
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
