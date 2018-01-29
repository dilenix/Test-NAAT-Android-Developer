package com.santander.arturojvm.promos.presenter;

import com.santander.arturojvm.promos.view.PromosView;

/**
 * Created by arturo on 15/02/17.
 */

public interface PromosPresenter {

    void onCreateView(PromosView view);

    void onDestroyView();

    void checkPromos();

    void onSearchPromosTextChange(CharSequence text);

}
