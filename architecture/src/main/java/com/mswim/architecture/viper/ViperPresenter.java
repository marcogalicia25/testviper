package com.mswim.architecture.viper;

import android.support.annotation.UiThread;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface ViperPresenter<V extends ViperView>{

    @UiThread
    void attachView(V view);

    @UiThread
    void detachView();

    @UiThread
    void onDestroy();

}
