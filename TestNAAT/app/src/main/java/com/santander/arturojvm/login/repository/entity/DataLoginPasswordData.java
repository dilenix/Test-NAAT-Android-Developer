package com.santander.arturojvm.login.repository.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arturo on 15/02/17.
 */

public class DataLoginPasswordData {

    @SerializedName("user")
    private String user;

    @SerializedName("pass")
    private String password;

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
