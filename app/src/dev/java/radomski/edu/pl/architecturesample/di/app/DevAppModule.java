package radomski.edu.pl.architecturesample.di.app;


import dagger.Module;
import radomski.edu.pl.architecturesample.App;

@Module
public class DevAppModule extends AppModule {
    public DevAppModule(App app) {
        super(app);
    }
}
