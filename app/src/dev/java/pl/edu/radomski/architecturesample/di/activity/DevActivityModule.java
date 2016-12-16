package pl.edu.radomski.architecturesample.di.activity;


import dagger.Module;
import pl.edu.radomski.architecturesample.ux.BaseActivity;

@Module
public class DevActivityModule extends ActivityModule {
    public DevActivityModule(BaseActivity activity) {
        super(activity);
    }
}
