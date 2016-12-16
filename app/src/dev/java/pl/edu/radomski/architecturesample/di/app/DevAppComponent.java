package pl.edu.radomski.architecturesample.di.app;


import dagger.Component;
import pl.edu.radomski.architecturesample.App;
import pl.edu.radomski.architecturesample.di.api.DevApiComponent;
import pl.edu.radomski.architecturesample.repository.dev.DevPlaygroundRepository;
import pl.edu.radomski.architecturesample.repository.home.HomeRepository;

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
