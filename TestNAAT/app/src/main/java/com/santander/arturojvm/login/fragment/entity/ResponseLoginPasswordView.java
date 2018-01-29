package com.santander.arturojvm.login.fragment.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by arturo on 15/02/17.
 */

public class ResponseLoginPasswordView implements Parcelable {

    private String agent;
    private String error;
    private String idUser;
    private String token;

    public ResponseLoginPasswordView() {}

    protected ResponseLoginPasswordView(Parcel in) {
        agent = in.readString();
        error = in.readString();
        idUser = in.readString();
        token = in.readString();
    }

    public static final Creator<ResponseLoginPasswordView> CREATOR = new Creator<ResponseLoginPasswordView>() {
        @Override
        public ResponseLoginPasswordView createFromParcel(Parcel in) {
            return new ResponseLoginPasswordView(in);
        }

        @Override
        public ResponseLoginPasswordView[] newArray(int size) {
            return new ResponseLoginPasswordView[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(agent);
        parcel.writeString(error);
        parcel.writeString(idUser);
        parcel.writeString(token);
    }
}
