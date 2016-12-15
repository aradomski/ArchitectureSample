package radomski.edu.pl.architecturesample.di.app;


import dagger.Component;
import radomski.edu.pl.architecturesample.App;
import radomski.edu.pl.architecturesample.di.api.DevApiComponent;
import radomski.edu.pl.architecturesample.repository.dev.DevPlaygroundRepository;
import radomski.edu.pl.architecturesample.repository.home.HomeRepository;

@AppScope
@Component(
        modules = {DevAppModule.class},
        dependencies = {DevApiComponent.class}
)
public interface DevAppComponent extends AppComponent {

    void inject(App app);


    DevPlaygroundRepository devPlaygroundRepository();

    HomeRepository homeRepository();
}
