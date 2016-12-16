package pl.edu.radomski.architecturesample.di;


import pl.edu.radomski.architecturesample.App;
import pl.edu.radomski.architecturesample.di.activity.DaggerDevActivityComponent;
import pl.edu.radomski.architecturesample.di.activity.DevActivityComponent;
import pl.edu.radomski.architecturesample.di.activity.DevActivityModule;
import pl.edu.radomski.architecturesample.di.api.DaggerDevApiComponent;
import pl.edu.radomski.architecturesample.di.api.DevApiComponent;
import pl.edu.radomski.architecturesample.di.api.DevApiModule;
import pl.edu.radomski.architecturesample.di.app.DaggerDevAppComponent;
import pl.edu.radomski.architecturesample.di.app.DevAppComponent;
import pl.edu.radomski.architecturesample.di.app.DevAppModule;
import pl.edu.radomski.architecturesample.ux.dev.DevPlaygroundActivity;

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