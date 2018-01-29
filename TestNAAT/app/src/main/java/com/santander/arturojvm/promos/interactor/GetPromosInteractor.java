package com.santander.arturojvm.promos.interactor;

import java.util.ArrayList;

import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;
import rx.Subscriber;

/**
 * Created by arturo on 15/02/17.
 */

public interface GetPromosInteractor {

    void execute(Subscriber<ArrayList<PromosInformationView>> subscriber);

    void unSubscribe();

}
