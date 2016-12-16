package pl.edu.radomski.architecturesample.utils.rx.cache;

import rx.Observable;
import rx.subjects.BehaviorSubject;

public class CacheHelper {


    interface WrapperBuilder<T> {
        CacheWrapper<T> build(T t);
    }


    public static <T> Observable<T> cachingCallWrap(BehaviorSubject<CacheWrapper<T>> cache, Observable<T> observable) {
        return wrap(cache, observable, CacheWrap::new);
    }

    public static <T> Observable<T> cachingTimeCallWrap(BehaviorSubject<CacheWrapper<T>> cache, Observable<T> observable) {
        return wrap(cache, observable, CacheWrapTime::new);
    }

    public static <T> Observable<T> cachingTimeCallWrap(BehaviorSubject<CacheWrapper<T>> cache, Observable<T> observable, int time) {
        WrapperBuilder<T> wrapperBuilder = value -> {
            CacheWrapTime<T> wrapTime = new CacheWrapTime<>(value);
            wrapTime.setCacheTime(time);
            return wrapTime;
        };
        return wrap(cache, observable, wrapperBuilder);
    }

    private static <T> Observable<T> wrap(BehaviorSubject<CacheWrapper<T>> cache, Observable<T> observable, WrapperBuilder<T> wrapperBuilder) {
        Observable<CacheWrapper<T>> cacheValue;

        if (cache.hasValue()) {
            cacheValue = Observable.just(cache.getValue());
        } else {
            cacheValue = Observable.empty();
        }
        return Observable.concat(cacheValue, observable.map(wrapperBuilder::build)
                .doOnNext(cache::onNext))
                .first(CacheWrapper::isValid)
                .map(CacheWrapper::getValue);
    }
}
