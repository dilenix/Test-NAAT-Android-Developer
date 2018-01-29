package com.santander.arturojvm.login.repository.service;

import com.santander.arturojvm.util.Constant;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by arturo on 15/02/17.
 */

public class ServiceLoginInterceptor implements Interceptor {

    @Override
    public Response intercept(Chain chain) throws IOException {

        Request.Builder builder = chain.request().newBuilder();

        builder.addHeader(Constant.SO_HEADER, Constant.SO_APPLICATION);
        builder.addHeader(Constant.VERSION_HEADER, Constant.VERSION_APPLICATION);

        return chain.proceed(builder.build());
    }

}
