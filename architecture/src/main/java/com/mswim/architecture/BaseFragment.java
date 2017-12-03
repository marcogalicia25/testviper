package com.mswim.architecture;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import com.mswim.architecture.viper.ViperDelegateCallback;
import com.mswim.architecture.viper.ViperPresenter;
import com.mswim.architecture.viper.ViperView;

/**
 * Created by marcogalicia on 25/10/16.
 */

public abstract class BaseFragment<V extends ViperView, P extends ViperPresenter<V>> extends Fragment
        implements ViperDelegateCallback<V, P>, ViperView {

    protected P presenter;

    @NonNull
    @Override
    public abstract P createPresenter();

    @Override
    public P getPresenter() {
        return presenter;
    }

    @Override
    public V getViperView() {
        return (V) this;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @Override
    public void onDetach() {
        super.onDetach();
    }
}
