package radomski.edu.pl.architecturesample.presenters.home;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.di.activity.ActivityScope;
import radomski.edu.pl.architecturesample.presenters.BasePresenter;
import radomski.edu.pl.architecturesample.repository.home.HomeRepository;

@ActivityScope
public class HomePresenter extends BasePresenter {

    @Inject
    HomeRepository homeRepository;


    @Inject
    public HomePresenter() {
    }
}
