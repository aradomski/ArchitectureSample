package pl.edu.radomski.architecturesample;

import net.danlew.android.joda.JodaTimeAndroid;

import pl.edu.radomski.architecturesample.di.DI;

public class App extends FlavouredApp {
    private static App app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        DI.getInjections().inject(this);

        JodaTimeAndroid.init(this);
    }

    public static App obtain() {
        return app;
    }
}
