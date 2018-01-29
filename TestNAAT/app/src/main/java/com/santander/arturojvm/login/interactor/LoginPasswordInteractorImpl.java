package com.santander.arturojvm.login.interactor;

import com.santander.arturojvm.login.fragment.entity.ResponseLoginPasswordView;
import com.santander.arturojvm.login.interactor.mapper.ResponseLoginMapper;
import com.santander.arturojvm.login.repository.LoginRepository;
import com.santander.arturojvm.login.repository.LoginRepositoryImpl;
import rx.Subscriber;
import rx.Subscription;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;
import rx.subscriptions.Subscriptions;

/**
 * Created by arturo on 15/02/17.
 */

public class LoginPasswordInteractorImpl implements LoginPasswordInteractor {

    private Subscription subscription = Subscriptions.empty();
    private LoginRepository repository;
    private ResponseLoginMapper mapper;

    public LoginPasswordInteractorImpl() {
        repository = LoginRepositoryImpl.getInstance();
        mapper = new ResponseLoginMapper();
    }

    @Override
    public void execute(Subscriber<ResponseLoginPasswordView> subscriber,
                        String user,
                        String password) {

        subscription = repository
                .loginPassword(user, password)
                .subscribeOn(Schedulers.newThread())
                .map(mapper::responseLoginTransform)
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
