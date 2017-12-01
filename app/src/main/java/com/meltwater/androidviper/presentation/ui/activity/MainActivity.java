package com.meltwater.androidviper.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meltwater.androidviper.R;
import com.meltwater.androidviper.presentation.presenter.MainPresenter;
import com.meltwater.androidviper.presentation.ui.Router.Router;
import com.meltwater.androidviper.presentation.ui.Router.RouterImp;
import com.meltwater.androidviper.presentation.view.MainView;
import com.mswim.architecture.BaseActivity;

public class MainActivity extends BaseActivity<MainView, MainPresenter> implements MainView {

    private TextView txtView;
    private Button btnView;
    private Button btnStopView;
    private Button btnRouterView;
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.text_main);
        btnView = findViewById(R.id.btn_go);
        btnStopView = findViewById(R.id.btn_stop);
        btnRouterView = findViewById(R.id.btn_router);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().doSomeWork();
            }
        });

        btnStopView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().stopCounter();
            }
        });

        btnRouterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().goNextScreen();
            }
        });

        router = new RouterImp(this);
    }

    @Override
    protected void onResume() {
        super.onResume();
        getPresenter().attachView(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        getPresenter().detachView();
    }

    @Override
    protected void onPresenterPrepared(@NonNull MainPresenter presenter) {
        Log.i("", "");
    }

    @Override
    protected int loaderId() {
        return 1;
    }

    @NonNull
    @Override
    protected String tag() {
        return this.getClass().getSimpleName();
    }

    @NonNull
    @Override
    public MainPresenter createPresenter() {
        return new MainPresenter();
    }

    @Override
    public void showLoading(boolean pullToRefresh) {

    }

    @Override
    public void showError(Throwable e, boolean pullToRefresh) {

    }

    @Override
    public void setData(String data) {
        txtView.setText(data);
    }

    @Override
    public void goNextScreen() {
        router.goNextScreen();
    }
}
