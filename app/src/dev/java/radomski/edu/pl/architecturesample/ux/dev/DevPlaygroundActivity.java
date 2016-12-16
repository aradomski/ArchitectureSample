package radomski.edu.pl.architecturesample.ux.dev;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Toast;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.R;
import radomski.edu.pl.architecturesample.databinding.DevPlaygroundActivityBinding;
import radomski.edu.pl.architecturesample.di.BaseComponent;
import radomski.edu.pl.architecturesample.di.DevDi;
import radomski.edu.pl.architecturesample.presenters.dev.DevPlaygroundPresenter;
import radomski.edu.pl.architecturesample.ux.BaseActivity;
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
            Timber.d("User:", user);
            dataBinding.setUser(user);
        }, throwable -> {
            Timber.d(throwable);
            Toast.makeText(this, "Error", Toast.LENGTH_SHORT).show();
        });
        subscribe(devPlaygroundPresenter.userRepos(dataBinding.username.getText().toString()), reposes -> {
            Timber.d("Repos:", reposes);
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
