package com.santander.arturojvm.promos.fragment.entity;

import android.graphics.drawable.Drawable;

/**
 * Created by arturo on 15/02/17.
 */

public class PromosInformationView {

    private Drawable imagePromo;
    private String informationPromo;

    public Drawable getImagePromo() {
        return imagePromo;
    }

    public void setImagePromo(Drawable imagePromo) {
        this.imagePromo = imagePromo;
    }

    public String getInformationPromo() {
        return informationPromo;
    }

    public void setInformationPromo(String informationPromo) {
        this.informationPromo = informationPromo;
    }
}
