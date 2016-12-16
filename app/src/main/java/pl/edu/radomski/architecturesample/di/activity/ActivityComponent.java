package pl.edu.radomski.architecturesample.di.activity;


import dagger.Component;
import pl.edu.radomski.architecturesample.di.BaseComponent;
import pl.edu.radomski.architecturesample.di.app.AppComponent;
import pl.edu.radomski.architecturesample.ux.BaseActivity;
import pl.edu.radomski.architecturesample.ux.home.HomeActivity;

@ActivityScope
@Component(
        modules = {ActivityModule.class},
        dependencies = {AppComponent.class}
)
public interface ActivityComponent extends BaseComponent {

    void inject(BaseActivity baseActivity);

    void inject(HomeActivity homeActivity);

}
