package com.meltwater.androidviper.presentation.presenter;

import com.meltwater.androidviper.domain.interactor.MainInteractor;
import com.meltwater.androidviper.domain.interactor.MainInteractorImp;
import com.meltwater.androidviper.presentation.view.MainView;
import com.mswim.architecture.viper.BasePresenter;


/**
 * Created by marcogalicia on 01/05/17.
 */

public class MainPresenter extends BasePresenter<MainView> implements MainInteractor {


    private final MainInteractorImp interactor;

    public MainPresenter() {
        interactor = new MainInteractorImp(this);
    }

    public void doSomeWork() {
        interactor.doSomeWork();
    }

    public void routerExample() {
        interactor.routerExample();
    }

    public void stopCounter() {
        interactor.removeSubscription();
    }

    @Override
    public void loadDataCallBack(String data) {
        if (isViewAttached())
            getView().setData(data);
    }

    @Override
    public void error(Throwable e) {

    }

    @Override
    public void goNextScreen() {
        if (isViewAttached())
            getView().goNextScreen();
    }
}
