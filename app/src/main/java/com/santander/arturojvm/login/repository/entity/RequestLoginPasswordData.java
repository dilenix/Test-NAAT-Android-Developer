package com.santander.arturojvm.login.repository.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arturo on 15/02/17.
 */

public class RequestLoginPasswordData {

    @SerializedName("data")
    private DataLoginPasswordData dataLogin;

    public DataLoginPasswordData getDataLogin() {
        return dataLogin;
    }

    public void setDataLogin(DataLoginPasswordData dataLogin) {
        this.dataLogin = dataLogin;
    }
}
