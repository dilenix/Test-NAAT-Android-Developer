package com.santander.arturojvm.login.presenter;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Log;

import com.santander.arturojvm.login.fragment.entity.ResponseLoginPasswordView;
import com.santander.arturojvm.login.interactor.LoginPasswordInteractor;
import com.santander.arturojvm.login.interactor.LoginPasswordInteractorImpl;
import com.santander.arturojvm.login.presenter.base.BasePresenter;
import com.santander.arturojvm.login.view.LoginView;
import com.santander.arturojvm.promos.PromosActivity;
import rx.Subscriber;

/**
 * Created by arturo on 15/02/17.
 */

public class LoginPresenterImpl extends BasePresenter<LoginView> implements LoginPresenter, Thread.UncaughtExceptionHandler {

    private LoginPasswordInteractor loginPasswordInteractor;
    private ResponseLoginPasswordView responseLoginPassword;

    @Override
    public void onCreateView(LoginView v) {
        setView(v);
        Thread.setDefaultUncaughtExceptionHandler(this);
        loginPasswordInteractor = new LoginPasswordInteractorImpl();
    }

    @Override
    public void onDestroyView() {
        setView(null);
        loginPasswordInteractor.unSubscribe();
    }

    @Override
    public void onBtnLoginSignUpClicked() {

        if (!areFieldsFilled()) return;

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loginPasswordInteractor.execute(
                        loginPasswordSubscriber(),
                        getView().getLoginUser(),
                        getView().getLoginPassword());
            }
        }, 3000);

    }

    private boolean areFieldsFilled() {

        boolean fieldsFilled = true;

        if (TextUtils.isEmpty(getView().getLoginUser())) {
            getView().showToast("Introduce el user");
            fieldsFilled = false;
        }

        if (TextUtils.isEmpty(getView().getLoginPassword())) {
            getView().showToast("Introduce el password");
            fieldsFilled = false;
        }
        return fieldsFilled;
    }

    private Subscriber<ResponseLoginPasswordView> loginPasswordSubscriber() {

        return new Subscriber<ResponseLoginPasswordView>() {

            @Override
            public void onCompleted() {

                if (responseLoginPassword.getIdUser().isEmpty()) return;

                getView().activity().startActivity(new Intent(getView().context(), PromosActivity.class));
            }

            @Override
            public void onError(Throwable e) {

                final AlertDialog.Builder builder = new AlertDialog.Builder(getView().activity());
                builder.setTitle("Error de conexión");
                builder.setMessage(e.getMessage());
                builder.setPositiveButton("Aceptar", (dialog, id) -> {});
                final AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();
            }

            @Override
            public void onNext(ResponseLoginPasswordView responseLoginPasswordView) {
                responseLoginPassword = responseLoginPasswordView;
            }
        };
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        if (e instanceof IllegalStateException) {
            Log.e("LoginPresenter", e.getMessage());
        }
    }
}
