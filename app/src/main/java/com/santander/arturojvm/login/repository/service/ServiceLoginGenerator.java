package com.santander.arturojvm.login.repository.service;

import java.util.concurrent.TimeUnit;

import com.santander.arturojvm.BuildConfig;
import com.santander.arturojvm.util.Constant;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by arturo on 21/09/16.
 */

public class ServiceLoginGenerator {

    private static final HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
    private static final OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder();
    private static final RxJavaCallAdapterFactory rxJavaCallAdapterFactory = RxJavaCallAdapterFactory.create();
    private static final GsonConverterFactory gsonConverterFactory = GsonConverterFactory.create();

    private static final Retrofit.Builder builder =
            new Retrofit.Builder()
                    .baseUrl(Constant.BASE_URL)
                    .addCallAdapterFactory(rxJavaCallAdapterFactory)
                    .addConverterFactory(gsonConverterFactory);

    public <S> S createService(Class<S> serviceClass) {

        if (BuildConfig.DEBUG) {
            httpLoggingInterceptor.setLevel(BuildConfig.DEBUG ? HttpLoggingInterceptor.Level.BODY : HttpLoggingInterceptor.Level.NONE);
            okHttpClient.addInterceptor(httpLoggingInterceptor);
        }

        final Retrofit retrofit;

        okHttpClient.writeTimeout(1, TimeUnit.MINUTES);
        okHttpClient.readTimeout(1, TimeUnit.MINUTES);
        okHttpClient.connectTimeout(1, TimeUnit.MINUTES);
        okHttpClient.addInterceptor(new ServiceLoginInterceptor());

        retrofit = builder.client(okHttpClient.build()).build();


        return retrofit.create(serviceClass);
    }
}
