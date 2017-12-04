package com.meltwater.androidviper.presentation.ui.activity;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.meltwater.androidviper.R;
import com.meltwater.androidviper.presentation.presenter.CarBrandsPresenter;
import com.meltwater.androidviper.presentation.ui.Router.Router;
import com.meltwater.androidviper.presentation.ui.Router.RouterImp;
import com.meltwater.androidviper.presentation.view.CarBrandView;
import com.mswim.architecture.BaseActivity;

public class MainActivity extends BaseActivity<CarBrandView, CarBrandsPresenter> implements CarBrandView {

    private TextView txtView;
    private Button btnView;
    private Button btnRouterView;
    private Router router;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txtView = findViewById(R.id.text_main);
        btnView = findViewById(R.id.btn_go);
        btnRouterView = findViewById(R.id.btn_router);

        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().getDatas();
            }
        });

        btnRouterView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getPresenter().routerNextScreen();
            }
        });

        router = new RouterImp(this);
    }

    @NonNull
    @Override
    public CarBrandsPresenter createPresenter() {
        return new CarBrandsPresenter();
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
    public void showDatas(String data) {
        txtView.setText(data);
    }

    @Override
    public void goNextScreen() {
        router.goNextScreen();
        finish();
    }

}
