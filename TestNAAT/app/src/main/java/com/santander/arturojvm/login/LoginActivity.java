package com.santander.arturojvm.login;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.santander.arturojvm.R;
import com.santander.arturojvm.login.fragment.LoginFragment;


public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        initPropierties();
    }

    private void initPropierties() {
        getSupportActionBar().hide();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, LoginFragment.newInstance(), LoginFragment.TAG)
                .commit();
    }

}

