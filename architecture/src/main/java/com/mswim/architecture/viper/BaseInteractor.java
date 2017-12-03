package com.mswim.architecture.viper;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface BaseInteractor {
    interface Input {
        void CarBrandsInteractorInput();
    }
    interface OutPut<T> {
        void CarBrandsInteractorOutput(T data);
    }
}
