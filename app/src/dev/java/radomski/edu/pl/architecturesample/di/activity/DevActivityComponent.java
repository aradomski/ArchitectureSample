package radomski.edu.pl.architecturesample.di.activity;

import dagger.Component;
import radomski.edu.pl.architecturesample.di.app.DevAppComponent;
import radomski.edu.pl.architecturesample.ux.BaseActivity;
import radomski.edu.pl.architecturesample.ux.dev.DevPlaygroundActivity;
import radomski.edu.pl.architecturesample.ux.home.HomeActivity;

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