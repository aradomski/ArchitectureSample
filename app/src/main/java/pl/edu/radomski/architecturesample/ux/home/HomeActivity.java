package pl.edu.radomski.architecturesample.ux.home;

import android.os.Bundle;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.R;
import pl.edu.radomski.architecturesample.databinding.HomeActivityBinding;
import pl.edu.radomski.architecturesample.di.BaseComponent;
import pl.edu.radomski.architecturesample.di.DI;
import pl.edu.radomski.architecturesample.presenters.home.HomePresenter;
import pl.edu.radomski.architecturesample.ux.BaseActivity;

public class HomeActivity extends BaseActivity {
    @Inject
    HomePresenter presenter;

    private HomeActivityBinding dataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        dataBinding = setView(R.layout.home_activity);
    }

    @Override
    protected BaseComponent inject() {
        return DI.getInjections().inject(this);
    }
}
