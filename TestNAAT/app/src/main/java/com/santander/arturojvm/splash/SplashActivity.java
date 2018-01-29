package com.santander.arturojvm.splash;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.WindowManager;

import com.santander.arturojvm.R;
import com.santander.arturojvm.splash.fragment.SplashFragment;

public class SplashActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        initPropierties();

    }

    private void initPropierties() {
        getSupportActionBar().hide();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.ll_activity_splash_container, SplashFragment.newInstance(), SplashFragment.TAG)
                .commit();
    }

}
