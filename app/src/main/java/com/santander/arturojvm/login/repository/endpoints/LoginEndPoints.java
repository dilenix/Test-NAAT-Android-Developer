package com.santander.arturojvm.login.repository.endpoints;

import com.santander.arturojvm.login.repository.entity.RequestLoginPasswordData;
import com.santander.arturojvm.login.repository.entity.ResponseLoginPasswordData;
import retrofit2.http.Body;
import retrofit2.http.POST;
import rx.Observable;

/**
 * Created by arturo on 15/02/17.
 */

public interface LoginEndPoints {

    @POST("agMov/login")
    Observable<ResponseLoginPasswordData> loginPassword(@Body RequestLoginPasswordData request);


}
