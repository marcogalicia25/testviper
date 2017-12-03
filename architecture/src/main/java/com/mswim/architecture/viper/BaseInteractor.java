package com.mswim.architecture.viper;

/**
 * Created by marcogalicia on 25/10/16.
 */

public interface BaseInteractor {
    interface Input {
        void carBrandsInteractorInput();
    }
    interface OutPut<T> {
        void carBrandsInteractorOutput(T data);
    }
}
