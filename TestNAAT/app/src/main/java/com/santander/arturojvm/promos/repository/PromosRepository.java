package com.santander.arturojvm.promos.repository;

import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;

import java.util.ArrayList;

import rx.Observable;

/**
 * Created by arturo on 15/02/17.
 */

public interface PromosRepository {

    Observable<ArrayList<PromosInformationView>> getPromos();

}
