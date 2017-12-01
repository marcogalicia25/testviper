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
    private static final String TAG = "base-activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getLoaderManager().initLoader(loaderId(), null, new LoaderManager.LoaderCallbacks<P>() {
            @Override
            public final Loader<P> onCreateLoader(int id, Bundle args) {
                Log.i(TAG, "onCreateLoader");
                return new PresenterLoader<>(BaseActivity.this, createPresenter(), tag());
            }

            @Override
            public final void onLoadFinished(Loader<P> loader, P presenter) {
                Log.i(TAG, "onLoadFinished");
                BaseActivity.this.presenter = presenter;
                onPresenterPrepared(presenter);
            }

            @Override
            public final void onLoaderReset(Loader<P> loader) {
                Log.i(TAG, "onLoaderReset");
                BaseActivity.this.presenter = null;
                onPresenterDestroyed();
            }
        });

    }


    protected abstract void onPresenterPrepared(@NonNull P presenter);

    protected void onPresenterDestroyed() {
    }

    protected abstract int loaderId();

    @NonNull
    protected abstract String tag();

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

    public BaseActivity getBaseActivity() {
        return BaseActivity.this;
    }

    @Override
    protected void onDestroy() {
        if (getPresenter() != null)
            getPresenter().onDestroy();
        super.onDestroy();
    }
}
