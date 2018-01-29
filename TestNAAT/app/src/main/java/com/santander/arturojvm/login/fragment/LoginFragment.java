package com.santander.arturojvm.login.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.santander.arturojvm.R;
import com.santander.arturojvm.login.LoginActivity;
import com.santander.arturojvm.login.presenter.LoginPresenter;
import com.santander.arturojvm.login.presenter.LoginPresenterImpl;
import com.santander.arturojvm.login.view.LoginView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by arturo on 15/02/17.
 */

public class LoginFragment extends Fragment implements LoginView {

    public static final String TAG = LoginFragment.class.getName();

    @BindView(R.id.et_login_user)
    EditText etLoginUser;

    @BindView(R.id.et_login_password)
    EditText etLoginPassword;

    @BindView(R.id.btn_login_sign_up)
    Button btnLoginSignUp;

    private LoginPresenter presenter;

    public static LoginFragment newInstance() {
        return new LoginFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_login, container, false);
        ButterKnife.bind(this, view);
        initPropierties();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }

    @Override
    public Context context() {
        return activity().getApplicationContext();
    }

    @Override
    public Activity activity() {
        return (LoginActivity) getActivity();
    }

    @Override
    public FragmentManager supportFragmentManager() {
        return ((LoginActivity) getActivity()).getSupportFragmentManager();
    }

    @Override
    public String getLoginUser() {
        return etLoginUser.getText().toString().trim();
    }

    @Override
    public String getLoginPassword() {
        return etLoginPassword.getText().toString().trim();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getActivity(), message, Toast.LENGTH_LONG).show();
    }

    @OnClick(R.id.btn_login_sign_up)
    protected void onBtnLoginSignUpClicked() {
        presenter.onBtnLoginSignUpClicked();
    }

    private void initPropierties() {
        presenter = new LoginPresenterImpl();
        presenter.onCreateView(this);
    }
}
