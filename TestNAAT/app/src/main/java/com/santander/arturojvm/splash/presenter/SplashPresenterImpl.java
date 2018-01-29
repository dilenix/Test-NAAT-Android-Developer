package com.santander.arturojvm.splash.presenter;

import android.content.Intent;

import java.util.concurrent.TimeUnit;

import com.santander.arturojvm.login.LoginActivity;
import com.santander.arturojvm.splash.view.SplashView;
import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by arturo on 15/02/17.
 */

public class SplashPresenterImpl implements SplashPresenter {

    private SplashView view;

    @Override
    public void onCreateView(SplashView v) {
        view = v;
    }

    @Override
    public void onDestroyView() {
        view = null;
    }

    @Override
    public void initSplashTimer() {

        if (view == null) return;

        Observable
                .interval(5, TimeUnit.SECONDS)
                .take(1)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(time -> {
                    view.getSplashActivity().startActivity(new Intent(view.getSplashContext(), LoginActivity.class));
                });
    }
}
