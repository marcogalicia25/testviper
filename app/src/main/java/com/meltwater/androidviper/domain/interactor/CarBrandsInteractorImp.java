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

public class CarBrandsInteractorImp implements CarBrandsInteractor.Input {

    private CarBrandsInteractor.OutPut<String> interactor;
    private final CompositeDisposable disposables = new CompositeDisposable();

    public CarBrandsInteractorImp(CarBrandsInteractor.OutPut<String> interactor) {
        this.interactor = interactor;
    }

    private Observable<? extends Long> getObservable() {
        return Observable.interval(0, 2, TimeUnit.SECONDS);
    }

    private DisposableObserver<Long> getObserver() {
        return new DisposableObserver<Long>() {

            @Override
            public void onNext(Long value) {
                interactor.CarBrandsInteractorOutput("Value: " + value);
            }

            @Override
            public void onError(Throwable e) {

            }

            @Override
            public void onComplete() {
                interactor.CarBrandsInteractorOutput("Complete!!!");
            }
        };
    }

    public void removeSubscription() {
        disposables.clear();
    }

    @Override
    public void CarBrandsInteractorInput() {
        disposables.add(getObservable()
                // Run on a background thread
                .subscribeOn(Schedulers.io())
                // Be notified on the main thread
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeWith(getObserver()));
    }
}
