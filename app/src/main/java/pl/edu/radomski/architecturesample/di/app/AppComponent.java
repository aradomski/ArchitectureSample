package pl.edu.radomski.architecturesample.di.app;


import dagger.Component;
import pl.edu.radomski.architecturesample.App;
import pl.edu.radomski.architecturesample.di.api.ApiComponent;
import pl.edu.radomski.architecturesample.repository.home.HomeRepository;

@AppScope
@Component(
        modules = {AppModule.class},
        dependencies = {ApiComponent.class}
)
public interface AppComponent {
    void inject(App app);

    HomeRepository homeRepository();
}
