package com.santander.arturojvm.login.view.base;

import android.app.Activity;
import android.content.Context;
import android.support.v4.app.FragmentManager;

/**
 * Created by Arturo Villanueva on 14/06/17.
 */

public interface BaseView {
    Context context();
    Activity activity();
    FragmentManager supportFragmentManager();
}
