package radomski.edu.pl.architecturesample.di;


import radomski.edu.pl.architecturesample.App;
import radomski.edu.pl.architecturesample.di.activity.DaggerDevActivityComponent;
import radomski.edu.pl.architecturesample.di.activity.DevActivityComponent;
import radomski.edu.pl.architecturesample.di.activity.DevActivityModule;
import radomski.edu.pl.architecturesample.di.api.DaggerDevApiComponent;
import radomski.edu.pl.architecturesample.di.api.DevApiComponent;
import radomski.edu.pl.architecturesample.di.api.DevApiModule;
import radomski.edu.pl.architecturesample.di.app.DaggerDevAppComponent;
import radomski.edu.pl.architecturesample.di.app.DevAppComponent;
import radomski.edu.pl.architecturesample.di.app.DevAppModule;
import radomski.edu.pl.architecturesample.ux.dev.DevPlaygroundActivity;

public class DevDi {


    private static DevDi di = new DevDi();
    private static Injections injections = new Injections();

    private DevDi() {
    }

    public static DevDi getDi() {
        return di;
    }

    public static Injections getInjections() {
        return injections;
    }

    public static class Injections {
        private DevAppComponent appComponent;
        private DevApiComponent apiComponent;

        private Injections() {
            apiComponent = DaggerDevApiComponent.builder().devApiModule(new DevApiModule()).build();
            appComponent = DaggerDevAppComponent.builder().devApiComponent(apiComponent).devAppModule(new DevAppModule(App.obtain())).build();
        }


        public DevActivityComponent inject(DevPlaygroundActivity developerMenuActivity) {
            DevActivityComponent activityComponent = DaggerDevActivityComponent.builder()
                    .devActivityModule(new DevActivityModule(developerMenuActivity))
                    .devAppComponent(appComponent)
                    .build();
            activityComponent.inject(developerMenuActivity);
            return activityComponent;
        }
    }
}