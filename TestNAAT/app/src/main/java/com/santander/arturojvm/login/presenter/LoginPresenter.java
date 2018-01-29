package com.santander.arturojvm.login.presenter;


import com.santander.arturojvm.login.view.LoginView;

/**
 * Created by arturo on 15/02/17.
 */

public interface LoginPresenter {

    void onCreateView(LoginView view);

    void onDestroyView();

    void onBtnLoginSignUpClicked();
}
