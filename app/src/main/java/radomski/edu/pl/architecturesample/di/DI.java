package radomski.edu.pl.architecturesample.di;

import radomski.edu.pl.architecturesample.App;
import radomski.edu.pl.architecturesample.di.activity.ActivityComponent;
import radomski.edu.pl.architecturesample.di.activity.ActivityModule;
import radomski.edu.pl.architecturesample.di.activity.DaggerActivityComponent;
import radomski.edu.pl.architecturesample.di.api.ApiComponent;
import radomski.edu.pl.architecturesample.di.api.ApiModule;
import radomski.edu.pl.architecturesample.di.api.DaggerApiComponent;
import radomski.edu.pl.architecturesample.di.app.AppComponent;
import radomski.edu.pl.architecturesample.di.app.AppModule;
import radomski.edu.pl.architecturesample.di.app.DaggerAppComponent;
import radomski.edu.pl.architecturesample.ux.BaseActivity;
import radomski.edu.pl.architecturesample.ux.home.HomeActivity;

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
