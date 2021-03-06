package pl.edu.radomski.architecturesample.di.api;

import com.google.gson.Gson;

import dagger.Component;

@ApiScope
@Component(
        modules = {ApiModule.class},
        dependencies = {}
)
public interface ApiComponent {

    Gson gson();
}
