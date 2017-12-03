package com.mswim.architecture;

import android.app.Activity;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.util.Log;

import com.mswim.architecture.viper.ViperDelegateCallback;
import com.mswim.architecture.viper.ViperPresenter;
import com.mswim.architecture.viper.ViperView;

public abstract class BaseActivity<V extends ViperView, P extends ViperPresenter<V>>
        extends Activity implements ViperDelegateCallback<V, P>, ViperView {

    protected P presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        presenter = createPresenter();
    }

    @NonNull
    @Override
    public abstract P createPresenter();

    @Override
    public P getPresenter() {
        return presenter;
    }

    @NonNull
    @Override
    public V getViperView() {
        return (V) this;
    }

    @Override
    public void finish() {
        if (getPresenter() != null)
            getPresenter().onFinish();
        super.finish();
    }
}
