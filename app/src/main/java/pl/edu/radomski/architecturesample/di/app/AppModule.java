package pl.edu.radomski.architecturesample.di.app;

import android.content.Context;
import android.content.SharedPreferences;


import dagger.Module;
import dagger.Provides;
import pl.edu.radomski.architecturesample.App;
import pl.edu.radomski.architecturesample.R;
import pl.edu.radomski.architecturesample.utils.ErrorHandler;

@Module
public class AppModule {

    private final App app;

    private SharedPreferences sharedPreferences;

    public AppModule(App app) {
        this.app = app;

        sharedPreferences = app.getSharedPreferences(app.getString(R.string.app_name), Context.MODE_PRIVATE);
    }

    @Provides
    public App app() {
        return app;
    }

    @Provides
    public Context context() {
        return app;
    }

    @Provides
    public SharedPreferences sharedPreferences() {
        return sharedPreferences;
    }


    @Provides
    public ErrorHandler errorHandler() {
        return new ErrorHandler(app);
    }


}
