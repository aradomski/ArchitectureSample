package pl.edu.radomski.architecturesample.di.api;

import com.google.gson.Gson;

import dagger.Component;
import pl.edu.radomski.architecturesample.api.dev.GithubSampleApiClient;

@ApiScope
@Component(
        modules = {DevApiModule.class},
        dependencies = {}
)
public interface DevApiComponent extends ApiComponent {
    Gson gson();


    GithubSampleApiClient githubSampleApiClient();
}
