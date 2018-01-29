package com.santander.arturojvm.login.presenter.base;


import com.santander.arturojvm.login.view.base.BaseView;

/**
 * Created by Arturo Villanueva on 14/06/17.
 */

public abstract class BasePresenter<T extends BaseView> {

    private T view;

    public T getView() throws IllegalStateException {
        if (view == null) {
            throw new IllegalStateException("View destroyed");
        }
        return view;
    }

    public void setView(T view) {
        this.view = view;
    }
}