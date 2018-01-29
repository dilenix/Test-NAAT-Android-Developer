package com.santander.arturojvm.splash.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.santander.arturojvm.R;
import com.santander.arturojvm.splash.SplashActivity;
import com.santander.arturojvm.splash.presenter.SplashPresenter;
import com.santander.arturojvm.splash.presenter.SplashPresenterImpl;
import com.santander.arturojvm.splash.view.SplashView;
import butterknife.ButterKnife;

/**
 * Created by arturo on 15/02/17.
 */

public class SplashFragment extends Fragment implements SplashView {

    public static final String TAG = SplashFragment.class.getName();
    private SplashPresenter presenter;

    public static SplashFragment newInstance() {
        return new SplashFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_splash, container, false);
        ButterKnife.bind(this, view);
        initPropierties();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }

    @Override
    public Context getSplashContext() {
        return getSplashActivity().getApplicationContext();
    }

    @Override
    public Activity getSplashActivity() {
        return (SplashActivity) getActivity();
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return ((SplashActivity) getSplashActivity()).getSupportFragmentManager();
    }

    private void initPropierties() {
        presenter = new SplashPresenterImpl();
        presenter.onCreateView(this);
        presenter.initSplashTimer();
    }
}
