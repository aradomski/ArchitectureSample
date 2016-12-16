package pl.edu.radomski.architecturesample.utils.rx;

import java.util.LinkedList;
import java.util.List;

import javax.inject.Inject;

import rx.Observable;
import rx.Observer;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

public class SubscriptionHelper {
    private List<Subscription> subscriptions = new LinkedList<>();

    @Inject
    public SubscriptionHelper() {
    }


    public <T> Subscription subscribe(Observable<T> observable, Observer<T> observer) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(observer);
        subscriptions.add(subscription);
        return subscription;
    }

    public <T> Subscription subscribe(Observable<T> observable, Action1<T> next, Action1<Throwable> error) {
        Subscription subscription = observable
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(next, error);
        subscriptions.add(subscription);
        return subscription;
    }


    public void clear() {
        for (Subscription subscription : subscriptions) {
            subscription.unsubscribe();
        }
    }
}
