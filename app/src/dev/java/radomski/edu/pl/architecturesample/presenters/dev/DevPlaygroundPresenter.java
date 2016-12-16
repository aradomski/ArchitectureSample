package radomski.edu.pl.architecturesample.presenters.dev;

import java.util.List;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.di.activity.ActivityScope;
import radomski.edu.pl.architecturesample.presenters.BasePresenter;
import radomski.edu.pl.architecturesample.presenters.dev.data.Repos;
import radomski.edu.pl.architecturesample.presenters.dev.data.User;
import radomski.edu.pl.architecturesample.repository.dev.DevPlaygroundRepository;
import rx.Observable;

@ActivityScope
public class DevPlaygroundPresenter extends BasePresenter {

    @Inject
    DevPlaygroundRepository devPlaygroundRepository;

    @Inject
    public DevPlaygroundPresenter() {
    }

    public Observable<User> user(String userName) {
        return devPlaygroundRepository.user(userName).map(User::new);
    }

    public Observable<List<Repos>> userRepos(String userName) {
        return devPlaygroundRepository.userRepos(userName).flatMap(Observable::from)
                .map(Repos::new)
                .toList();
    }

    public void invalidateCache() {
        devPlaygroundRepository.invalidateCache();
    }
}
