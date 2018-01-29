package com.santander.arturojvm.promos.repository;

import android.content.Context;

import java.util.ArrayList;

import com.santander.arturojvm.R;
import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;
import rx.Observable;

/**
 * Created by arturo on 15/02/17.
 */

public class PromosRepositoryImpl implements PromosRepository {

    private static PromosRepositoryImpl promosRepository;
    private static Context context;

    public static PromosRepositoryImpl getInstance(Context c) {
        if (promosRepository == null) {
            promosRepository = new PromosRepositoryImpl();
            context = c;
        }
        return promosRepository;
    }

    @Override
    public Observable<ArrayList<PromosInformationView>> getPromos() {

        ArrayList<PromosInformationView> promosInformation = new ArrayList<>();

        PromosInformationView promo1 = new PromosInformationView();
        promo1.setInformationPromo("Farmacias Benavides");
        promo1.setImagePromo(context.getResources().getDrawable(R.drawable.promo_benavides));

        PromosInformationView promo2 = new PromosInformationView();
        promo2.setInformationPromo("Burger King");
        promo2.setImagePromo(context.getResources().getDrawable(R.drawable.promo_burger_king));

        PromosInformationView promo3 = new PromosInformationView();
        promo3.setInformationPromo("Chillis");
        promo3.setImagePromo(context.getResources().getDrawable(R.drawable.promo_chillis));

        PromosInformationView promo4 = new PromosInformationView();
        promo4.setInformationPromo("Cinepolis");
        promo4.setImagePromo(context.getResources().getDrawable(R.drawable.promo_cinepolis));

        PromosInformationView promo5 = new PromosInformationView();
        promo5.setInformationPromo("Idea");
        promo5.setImagePromo(context.getResources().getDrawable(R.drawable.promo_idea));

        PromosInformationView promo6 = new PromosInformationView();
        promo6.setInformationPromo("Italianis");
        promo6.setImagePromo(context.getResources().getDrawable(R.drawable.promo_itallianis));

        PromosInformationView promo7 = new PromosInformationView();
        promo7.setInformationPromo("Papa Johns");
        promo7.setImagePromo(context.getResources().getDrawable(R.drawable.promo_papa_johns));

        PromosInformationView promo8 = new PromosInformationView();
        promo8.setInformationPromo("Tizoncito");
        promo8.setImagePromo(context.getResources().getDrawable(R.drawable.promo_tizoncito));

        PromosInformationView promo9 = new PromosInformationView();
        promo9.setInformationPromo("Wing Stop");
        promo9.setImagePromo(context.getResources().getDrawable(R.drawable.promo_wing_stop));

        PromosInformationView promo10 = new PromosInformationView();
        promo10.setInformationPromo("Zona Fitness");
        promo10.setImagePromo(context.getResources().getDrawable(R.drawable.promo_zona_fitness));


        promosInformation.add(promo1);
        promosInformation.add(promo2);
        promosInformation.add(promo3);
        promosInformation.add(promo4);
        promosInformation.add(promo5);
        promosInformation.add(promo6);
        promosInformation.add(promo7);
        promosInformation.add(promo8);
        promosInformation.add(promo9);
        promosInformation.add(promo10);

        return Observable.just(promosInformation);
    }

}
