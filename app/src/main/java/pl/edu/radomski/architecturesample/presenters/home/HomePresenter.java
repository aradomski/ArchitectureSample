package pl.edu.radomski.architecturesample.presenters.home;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.di.activity.ActivityScope;
import pl.edu.radomski.architecturesample.presenters.BasePresenter;
import pl.edu.radomski.architecturesample.repository.home.HomeRepository;

@ActivityScope
public class HomePresenter extends BasePresenter {

    @Inject
    HomeRepository homeRepository;


    @Inject
    public HomePresenter() {
    }
}
