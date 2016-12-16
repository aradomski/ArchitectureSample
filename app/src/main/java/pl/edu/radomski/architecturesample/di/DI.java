package pl.edu.radomski.architecturesample.di;

import pl.edu.radomski.architecturesample.App;
import pl.edu.radomski.architecturesample.di.activity.ActivityComponent;
import pl.edu.radomski.architecturesample.di.activity.ActivityModule;
import pl.edu.radomski.architecturesample.di.activity.DaggerActivityComponent;
import pl.edu.radomski.architecturesample.di.api.ApiComponent;
import pl.edu.radomski.architecturesample.di.api.ApiModule;
import pl.edu.radomski.architecturesample.di.api.DaggerApiComponent;
import pl.edu.radomski.architecturesample.di.app.AppComponent;
import pl.edu.radomski.architecturesample.di.app.AppModule;
import pl.edu.radomski.architecturesample.di.app.DaggerAppComponent;
import pl.edu.radomski.architecturesample.ux.BaseActivity;
import pl.edu.radomski.architecturesample.ux.home.HomeActivity;

public class DI {

    private static DI di = new DI();
    private static Injections injections = new Injections();

    private DI() {
    }

    public static DI getDi() {
        return di;
    }

    public static Injections getInjections() {
        return injections;
    }

    public static class Injections {
        private AppComponent appComponent;
        private ApiComponent apiComponent;

        private Injections() {
            apiComponent = DaggerApiComponent.builder().apiModule(new ApiModule()).build();
        }

        public void inject(App app) {
            appComponent = DaggerAppComponent.builder().apiComponent(apiComponent).appModule(new AppModule(app)).build();
            appComponent.inject(app);
        }

        //region Activities
        public ActivityComponent inject(BaseActivity baseActivity) {
            ActivityComponent activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(baseActivity))
                    .appComponent(appComponent)
                    .build();
            activityComponent.inject(baseActivity);
            return activityComponent;
        }

        public ActivityComponent inject(HomeActivity homeActivity) {
            ActivityComponent activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(homeActivity))
                    .appComponent(appComponent)
                    .build();
            activityComponent.inject(homeActivity);
            return activityComponent;
        }


        //endregion
    }
}
