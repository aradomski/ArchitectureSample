package radomski.edu.pl.architecturesample.di.activity;


import dagger.Component;
import radomski.edu.pl.architecturesample.di.BaseComponent;
import radomski.edu.pl.architecturesample.di.app.AppComponent;
import radomski.edu.pl.architecturesample.repository.home.HomeRepository;
import radomski.edu.pl.architecturesample.ux.BaseActivity;
import radomski.edu.pl.architecturesample.ux.home.HomeActivity;

@ActivityScope
@Component(
        modules = {ActivityModule.class},
        dependencies = {AppComponent.class}
)
public interface ActivityComponent extends BaseComponent {

    void inject(BaseActivity baseActivity);

    void inject(HomeActivity homeActivity);

}
