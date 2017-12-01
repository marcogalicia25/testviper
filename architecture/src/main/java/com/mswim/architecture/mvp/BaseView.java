package com.mswim.architecture.mvp;

import android.support.annotation.UiThread;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface BaseView<M> extends MvpView {

    @UiThread
    public void showLoading(boolean pullToRefresh);

    @UiThread
    public void showError(Throwable e, boolean pullToRefresh);

    @UiThread
    public void setData(M data);

}
