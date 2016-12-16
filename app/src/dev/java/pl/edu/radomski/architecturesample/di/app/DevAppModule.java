package pl.edu.radomski.architecturesample.di.app;


import dagger.Module;
import pl.edu.radomski.architecturesample.App;

@Module
public class DevAppModule extends AppModule {
    public DevAppModule(App app) {
        super(app);
    }
}
