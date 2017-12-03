package com.meltwater.androidviper.presentation.presenter;

import com.meltwater.androidviper.domain.interactor.CarBrandsInteractor;
import com.meltwater.androidviper.domain.interactor.CarBrandsInteractorImp;
import com.meltwater.androidviper.presentation.view.CarBrandView;
import com.mswim.architecture.viper.BasePresenter;

/**
 * Created by marcogalicia on 01/05/17.
 */

public class CardBrandsPresenter extends BasePresenter<CarBrandView> implements CarBrandsInteractor.OutPut<String> {


    private final CarBrandsInteractorImp interactor;

    public CardBrandsPresenter() {
        interactor = new CarBrandsInteractorImp(this);
    }

    //Here we can declare this method in a interface to be more formal.
    //Or simply declare the method inside the presenter.
    //actually the same for Input/Output in the interactor. :)
    public void getDatas() {
        interactor.carBrandsInteractorInput();
    }

    public void routerNextScreen() {
        if (isViewAttached())
            getView().goNextScreen();
    }

    @Override
    public void carBrandsInteractorOutput(String data) {
        if (isViewAttached())
            getView().showDatas(data);
    }

    //This method only is executed when the activity is completely destroyed.
    //onDestroy could be called onConfigurationChanged
    @Override
    public void onFinish() {
        if (interactor != null)
            interactor.removeSubscription();
        super.onFinish();
    }
}
