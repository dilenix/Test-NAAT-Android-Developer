package com.santander.arturojvm.promos.view;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;
import android.widget.GridView;

import com.santander.arturojvm.promos.adapter.PromosAdapter;

/**
 * Created by arturo on 15/02/17.
 */

public interface PromosView {

    Context getPromosContext();

    Activity getPromosActivity();

    FragmentManager getSupportFragmentManager();

    void showToast(String message);

    void setGvPromosAdapter(PromosAdapter adapter);

    GridView getGvPromos();
}
