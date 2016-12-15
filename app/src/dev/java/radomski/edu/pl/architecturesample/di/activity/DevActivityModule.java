package radomski.edu.pl.architecturesample.di.activity;


import dagger.Module;
import radomski.edu.pl.architecturesample.ux.BaseActivity;

@Module
public class DevActivityModule extends ActivityModule {
    public DevActivityModule(BaseActivity activity) {
        super(activity);
    }
}
