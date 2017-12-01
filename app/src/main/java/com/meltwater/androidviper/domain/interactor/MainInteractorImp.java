package com.meltwater.androidviper.domain.interactor;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.Single;
import io.reactivex.SingleObserver;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;
import io.reactivex.observers.DisposableObserver;
import io.reactivex.schedulers.Schedulers;


/**
 * Created by marcogalicia on 01/05/17.
 */

public class MainInteractorImp {

    private MainInteractor interf;
    private final CompositeDisposable disposables = new CompositeDisposable();

    public MainInteractorImp(MainInteractor interf) {
        this.interf = interf;
    }

    public void routerExample() {
        Single.just("Meltwater")
                .subscribe(getSingleObserver());
    }

    private SingleObserver<String> getSingleObserver() {
        return new SingleObserver<String>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onSuccess(String value) {
                interf.goNextScreen();
            }

            @Override
            public void onError(Throwable e) {

            }
        };
    }


    public void doSomeWork() {
        disposables.add(getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));
    }

    private Observable<? extends Long> getObservable() {
        return Observable.interval(0, 2, TimeUnit.SECONDS);
    }

    private DisposableObserver<Long> getObserver() {
        return new DisposableObserver<Long>() {

            @Override
            public void onNext(Long value) {
                interf.loadDataCallBack("Value: "+value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                interf.loadDataCallBack("Complete!!!");
            }
        };
    }

    public void removeSubscription() {
        disposables.clear();
    }
}
