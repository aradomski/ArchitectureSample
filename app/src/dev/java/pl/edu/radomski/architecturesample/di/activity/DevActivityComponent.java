package pl.edu.radomski.architecturesample.di.activity;

import dagger.Component;
import pl.edu.radomski.architecturesample.di.app.DevAppComponent;
import pl.edu.radomski.architecturesample.ux.BaseActivity;
import pl.edu.radomski.architecturesample.ux.dev.DevPlaygroundActivity;
import pl.edu.radomski.architecturesample.ux.home.HomeActivity;

@ActivityScope
@Component(
        modules = {DevActivityModule.class},
        dependencies = {DevAppComponent.class}
)
public interface DevActivityComponent extends ActivityComponent {
    void inject(BaseActivity baseActivity);

    void inject(HomeActivity homeActivity);

    void inject(DevPlaygroundActivity devPlaygroundActivity);
}