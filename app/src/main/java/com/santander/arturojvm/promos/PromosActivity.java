package com.santander.arturojvm.promos;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.santander.arturojvm.R;
import com.santander.arturojvm.promos.fragment.PromosFragment;

public class PromosActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_promos);
        initPropierties();
    }

    private void initPropierties() {
        getSupportActionBar().hide();
        getSupportFragmentManager()
                .beginTransaction()
                .add(R.id.container, PromosFragment.newInstance(), PromosFragment.TAG)
                .commit();
    }
}
