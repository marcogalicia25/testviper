package com.meltwater.androidviper.presentation.ui.Router;

import android.content.Context;
import android.content.Intent;

import com.meltwater.androidviper.presentation.ui.activity.SecondActivity;

/**
 * Created by marcogalicia on 11/30/17.
 */

public class RouterImp implements Router {

    private Context context;

    public RouterImp(Context context) {
        this.context = context;
    }

    @Override
    public void goNextScreen() {
        Intent i = new Intent(context, SecondActivity.class);
        context.startActivity(i);
    }
}
