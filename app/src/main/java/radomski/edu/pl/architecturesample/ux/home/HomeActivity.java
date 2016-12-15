package radomski.edu.pl.architecturesample.ux.home;

import android.os.Bundle;

import javax.inject.Inject;

import radomski.edu.pl.architecturesample.R;
import radomski.edu.pl.architecturesample.databinding.HomeActivityBinding;
import radomski.edu.pl.architecturesample.di.BaseComponent;
import radomski.edu.pl.architecturesample.di.DI;
import radomski.edu.pl.architecturesample.presenters.home.HomePresenter;
import radomski.edu.pl.architecturesample.ux.BaseActivity;

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
