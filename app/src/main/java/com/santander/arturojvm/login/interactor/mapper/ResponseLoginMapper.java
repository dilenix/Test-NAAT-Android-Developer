package com.santander.arturojvm.login.interactor.mapper;

import com.santander.arturojvm.login.fragment.entity.ResponseLoginPasswordView;
import com.santander.arturojvm.login.repository.entity.ResponseLoginPasswordData;

/**
 * Created by arturo on 15/02/17.
 */

public class ResponseLoginMapper {

    public ResponseLoginPasswordView responseLoginTransform(ResponseLoginPasswordData responseLoginPasswordData) {

        ResponseLoginPasswordView responseLoginPasswordView = null;

        if (responseLoginPasswordData != null) {
            responseLoginPasswordView = new ResponseLoginPasswordView();
            responseLoginPasswordView.setAgent(responseLoginPasswordData.getAgent());
            responseLoginPasswordView.setError(responseLoginPasswordData.getError());
            responseLoginPasswordView.setIdUser(responseLoginPasswordData.getIdUser());
            responseLoginPasswordView.setToken(responseLoginPasswordData.getToken());
        }

        return responseLoginPasswordView;
    }
}
