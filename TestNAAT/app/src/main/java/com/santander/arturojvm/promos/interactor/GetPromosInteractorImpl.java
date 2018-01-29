package com.santander.arturojvm.promos.interactor;

import android.content.Context;

import java.util.ArrayList;

import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;
import com.santander.arturojvm.promos.repository.PromosRepository;
import com.santander.arturojvm.promos.repository.PromosRepositoryImpl;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by arturo on 15/02/17.
 */

public class GetPromosInteractorImpl implements GetPromosInteractor {

    private Subscription subscription = Subscriptions.empty();
    private PromosRepository repository;

    public GetPromosInteractorImpl(Context context) {
        repository = PromosRepositoryImpl.getInstance(context);
    }

    @Override
    public void execute(Subscriber<ArrayList<PromosInformationView>> subscriber) {
        subscription = repository
                .getPromos()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(subscriber);
    }

    @Override
    public void unSubscribe() {
        if (!subscription.isUnsubscribed()) {
            subscription.unsubscribe();
        }
    }

}
