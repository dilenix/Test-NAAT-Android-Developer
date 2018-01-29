package com.santander.arturojvm.login.repository;

import com.santander.arturojvm.login.repository.entity.ResponseLoginPasswordData;

import rx.Observable;

/**
 * Created by arturo on 15/02/17.
 */

public interface LoginRepository {

    Observable<ResponseLoginPasswordData> loginPassword(String user,
                                                        String password);

}
