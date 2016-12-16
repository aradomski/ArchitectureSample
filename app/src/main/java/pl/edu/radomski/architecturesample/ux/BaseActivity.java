package pl.edu.radomski.architecturesample.ux;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import javax.inject.Inject;

import pl.edu.radomski.architecturesample.di.BaseComponent;
import pl.edu.radomski.architecturesample.di.DI;
import pl.edu.radomski.architecturesample.utils.ErrorHandler;
import pl.edu.radomski.architecturesample.utils.rx.SubscriptionHelper;
import rx.Observable;
import rx.Subscription;
import rx.functions.Action1;

public class BaseActivity extends FlavouredActivity {

    private static final String TAG = BaseActivity.class.getSimpleName();

    @Inject
    SubscriptionHelper subscriptionHelper;
    @Inject
    ErrorHandler errorHandler;
    private BaseComponent baseComponent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        baseComponent = inject();
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        throw new RuntimeException("use setView()");
    }

    protected BaseComponent inject() {
        return DI.getInjections().inject(this);
    }

    public <T extends ViewDataBinding> T setView(@LayoutRes int layoutResID) {
        LayoutInflater layoutInflater = LayoutInflater.from(this);
        View activityView;
        activityView = layoutInflater.inflate(layoutResID, getRootView(), false);
        super.setContentView(activityView);
        return (T) DataBindingUtil.bind(activityView);
    }

    private ViewGroup getRootView() {
        return (ViewGroup) findViewById(android.R.id.content);
    }

    public <T> Subscription subscribe(Observable<T> pages, Action1<T> onNext, Action1<Throwable> onError) {
        return subscriptionHelper.subscribe(pages, onNext, throwable -> {
            errorHandler.handleError(throwable);
            onError.call(throwable);
        });
    }

}
