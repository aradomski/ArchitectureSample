package pl.edu.radomski.architecturesample.presenters.dev;

import java.util.List;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.api.dev.data.ApiFollower;
import pl.edu.radomski.architecturesample.di.activity.ActivityScope;
import pl.edu.radomski.architecturesample.presenters.BasePresenter;
import pl.edu.radomski.architecturesample.presenters.dev.data.Follower;
import pl.edu.radomski.architecturesample.presenters.dev.data.Repos;
import pl.edu.radomski.architecturesample.presenters.dev.data.User;
import pl.edu.radomski.architecturesample.repository.dev.DevPlaygroundRepository;
import pl.edu.radomski.architecturesample.utils.rx.cache.CacheHelper;
import rx.Observable;
import rx.functions.Func1;

@ActivityScope
public class DevPlaygroundPresenter extends BasePresenter {

    @Inject
    DevPlaygroundRepository devPlaygroundRepository;

    @Inject
    public DevPlaygroundPresenter() {
    }

    public Observable<User> user(String userName) {
        return devPlaygroundRepository.user(userName)
                .map(User::new);
    }

    public Observable<List<Repos>> userRepos(String userName) {
        return devPlaygroundRepository.userRepos(userName)
                .flatMap(Observable::from)
                .map(Repos::new)
                .toList();
    }
    public Observable<List<Follower>> userFolowers(String userName) {
        return devPlaygroundRepository.userFolowers(userName)
                .flatMap(Observable::from)
                .map(Follower::new)
                .toList();
    }
    public void invalidateCache() {
        devPlaygroundRepository.invalidateCache();
    }
}
