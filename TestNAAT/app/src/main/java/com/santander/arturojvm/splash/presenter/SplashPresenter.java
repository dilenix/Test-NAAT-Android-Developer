package com.santander.arturojvm.splash.presenter;

import com.santander.arturojvm.splash.view.SplashView;

/**
 * Created by arturo on 15/02/17.
 */

public interface SplashPresenter {

    void onCreateView(SplashView view);
    void onDestroyView();

    void initSplashTimer();

}
