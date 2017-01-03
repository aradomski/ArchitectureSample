package pl.edu.radomski.architecturesample.presenters.dev;

import com.fernandocejas.frodo.annotation.RxLogObservable;
import com.fernandocejas.frodo.annotation.RxLogSubscriber;

import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import hugo.weaving.DebugLog;
import pl.edu.radomski.architecturesample.di.activity.ActivityScope;
import pl.edu.radomski.architecturesample.presenters.BasePresenter;
import pl.edu.radomski.architecturesample.presenters.dev.data.Follower;
import pl.edu.radomski.architecturesample.presenters.dev.data.Repos;
import pl.edu.radomski.architecturesample.presenters.dev.data.User;
import pl.edu.radomski.architecturesample.repository.dev.DevPlaygroundRepository;
import rx.Observable;

@ActivityScope
public class DevPlaygroundPresenter extends BasePresenter {

    @Inject
    DevPlaygroundRepository devPlaygroundRepository;

    @Inject
    public DevPlaygroundPresenter() {
    }

    @RxLogObservable
    public Observable<User> user(String userName) {
        return devPlaygroundRepository.user(userName).delay(new Random().nextInt(5), TimeUnit.SECONDS)
                .map(User::new);
    }

    @DebugLog
    public Observable<List<Repos>> userRepos(String userName) {
        return devPlaygroundRepository.userRepos(userName).delay(new Random().nextInt(5), TimeUnit.SECONDS)
                .flatMap(Observable::from)
                .map(Repos::new)
                .toList();
    }

    public Observable<List<Follower>> userFolowers(String userName) {
        return devPlaygroundRepository.userFolowers(userName).delay(new Random().nextInt(5), TimeUnit.SECONDS)
                .flatMap(Observable::from)
                .map(Follower::new)
                .toList();
    }

    public void invalidateCache() {
        devPlaygroundRepository.invalidateCache();
    }
}
