package radomski.edu.pl.architecturesample.repository.home;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.di.app.AppScope;
import radomski.edu.pl.architecturesample.repository.BaseRepository;

@AppScope
public class HomeRepository extends BaseRepository {


    @Inject
    public HomeRepository() {
    }
}
