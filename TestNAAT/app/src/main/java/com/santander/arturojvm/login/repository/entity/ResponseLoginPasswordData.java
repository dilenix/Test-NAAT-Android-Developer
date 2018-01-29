package com.santander.arturojvm.login.repository.entity;

import com.google.gson.annotations.SerializedName;

/**
 * Created by arturo on 15/02/17.
 */

public class ResponseLoginPasswordData {

    @SerializedName("agente")
    private String agent;

    @SerializedName("error")
    private String error;

    @SerializedName("id_user")
    private String idUser;

    @SerializedName("token")
    private String token;

    public String getAgent() {
        return agent;
    }

    public void setAgent(String agent) {
        this.agent = agent;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
