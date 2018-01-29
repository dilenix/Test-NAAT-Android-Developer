package com.santander.arturojvm.splash.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by arturo on 15/02/17.
 */

public interface SplashView {

    Context getSplashContext();

    Activity getSplashActivity();

    FragmentManager getSupportFragmentManager();

}
