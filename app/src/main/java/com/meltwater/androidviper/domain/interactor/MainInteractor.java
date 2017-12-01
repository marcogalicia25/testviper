package com.meltwater.androidviper.domain.interactor;

import com.mswim.architecture.mvp.BaseInteractor;

/**
 * Created by marcogalicia on 11/30/17.
 */

public interface MainInteractor extends BaseInteractor<String> {
    void goNextScreen();
}
