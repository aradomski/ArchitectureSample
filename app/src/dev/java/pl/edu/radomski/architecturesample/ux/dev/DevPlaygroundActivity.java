package pl.edu.radomski.architecturesample.ux.dev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.widget.Toast;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.R;
import pl.edu.radomski.architecturesample.databinding.DevPlaygroundActivityBinding;
import pl.edu.radomski.architecturesample.di.BaseComponent;
import pl.edu.radomski.architecturesample.di.DevDi;
import pl.edu.radomski.architecturesample.presenters.dev.DevPlaygroundPresenter;
import pl.edu.radomski.architecturesample.ux.BaseActivity;
import timber.log.Timber;

public class DevPlaygroundActivity extends BaseActivity {

    @Inject
    DevPlaygroundPresenter devPlaygroundPresenter;
    private DevPlaygroundActivityBinding dataBinding;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = setView(R.layout.dev_playground_activity);

        dataBinding.refresh.setOnClickListener(v -> refresh());
        dataBinding.invalidateCache.setOnClickListener(v -> devPlaygroundPresenter.invalidateCache());
        refresh();
    }

    private void refresh() {
        subscribe(devPlaygroundPresenter.user(dataBinding.username.getText().toString()), user -> {
            dataBinding.setUser(user);
        }, throwable -> {
            Timber.d(throwable);
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        });
        subscribe(devPlaygroundPresenter.userRepos(dataBinding.username.getText().toString()), reposes -> {
            if (reposes.size() > 0) {
                dataBinding.setRepos(reposes.get(0));
            }
        }, throwable -> {
            Timber.d(throwable);
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    protected BaseComponent inject() {
        return DevDi.getInjections().inject(this);
    }
}
