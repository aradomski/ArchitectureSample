package radomski.edu.pl.architecturesample.di.api;

import com.google.gson.Gson;

import dagger.Component;
import radomski.edu.pl.architecturesample.api.dev.GithubSampleApiClient;

@ApiScope
@Component(
        modules = {DevApiModule.class},
        dependencies = {}
)
public interface DevApiComponent extends ApiComponent {
    Gson gson();


    GithubSampleApiClient githubSampleApiClient();
}
