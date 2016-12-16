package pl.edu.radomski.architecturesample.repository.home;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.di.app.AppScope;
import pl.edu.radomski.architecturesample.repository.BaseRepository;

@AppScope
public class HomeRepository extends BaseRepository {


    @Inject
    public HomeRepository() {
    }
}
