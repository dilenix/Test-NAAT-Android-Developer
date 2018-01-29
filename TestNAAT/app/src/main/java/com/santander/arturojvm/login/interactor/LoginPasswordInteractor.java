package com.santander.arturojvm.login.interactor;

import com.santander.arturojvm.login.fragment.entity.ResponseLoginPasswordView;

import rx.Subscriber;

/**
 * Created by arturo on 15/02/17.
 */

public interface LoginPasswordInteractor {

    void execute(Subscriber<ResponseLoginPasswordView> subscriber,
                 String user,
                 String password);

    void unSubscribe();

}
