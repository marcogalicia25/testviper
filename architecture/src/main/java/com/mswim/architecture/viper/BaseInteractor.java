package com.mswim.architecture.viper;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface BaseInteractor<T> {
    void loadDataCallBack(T data);
    void error(Throwable e);
}
