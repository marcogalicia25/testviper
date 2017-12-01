package com.mswim.architecture.viper;

import android.support.annotation.NonNull;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface ViperDelegateCallback<V extends ViperView, P extends ViperPresenter<V>> {
    @NonNull
    public P createPresenter();
    public P getPresenter();
    public V getViperView();
}
