package radomski.edu.pl.architecturesample.di.activity;

import android.content.Context;

import dagger.Module;
import dagger.Provides;
import radomski.edu.pl.architecturesample.utils.ErrorHandler;
import radomski.edu.pl.architecturesample.ux.BaseActivity;

@Module
public class ActivityModule {
    private final BaseActivity activity;

    public ActivityModule(BaseActivity activity) {
        this.activity = activity;
    }

    @Provides
    public Context context() {
        return activity;
    }

    @Provides
    public BaseActivity baseActivity() {
        return activity;
    }

    @Provides
    public ErrorHandler errorHandler() {
        return new ErrorHandler(activity);
    }
}
