package radomski.edu.pl.architecturesample.di.app;


import dagger.Component;
import radomski.edu.pl.architecturesample.App;
import radomski.edu.pl.architecturesample.di.api.ApiComponent;
import radomski.edu.pl.architecturesample.repository.home.HomeRepository;

@AppScope
@Component(
        modules = {AppModule.class},
        dependencies = {ApiComponent.class}
)
public interface AppComponent {
    void inject(App app);

    HomeRepository homeRepository();
}
