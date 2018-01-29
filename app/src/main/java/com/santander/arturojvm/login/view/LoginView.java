package com.santander.arturojvm.login.view;


import com.santander.arturojvm.login.view.base.BaseView;

/**
 * Created by arturo on 15/02/17.
 */

public interface LoginView extends BaseView {

    String getLoginUser();

    String getLoginPassword();

    void showToast(String message);

}
