package com.santander.arturojvm.promos.presenter;

import android.app.AlertDialog;

import java.util.ArrayList;

import com.santander.arturojvm.promos.adapter.PromosAdapter;
import com.santander.arturojvm.promos.fragment.entity.PromosInformationView;
import com.santander.arturojvm.promos.interactor.GetPromosInteractor;
import com.santander.arturojvm.promos.interactor.GetPromosInteractorImpl;
import com.santander.arturojvm.promos.view.PromosView;
import rx.Subscriber;

/**
 * Created by arturo on 15/02/17.
 */

public class PromosPresenterImpl implements PromosPresenter {

    private PromosView view;

    private GetPromosInteractor getPromosInteractor;

    private ArrayList<PromosInformationView> promosInformation;
    private PromosAdapter promosAdapter;

    @Override
    public void onCreateView(PromosView v) {
        view = v;
        getPromosInteractor = new GetPromosInteractorImpl(view.getPromosContext());
    }

    @Override
    public void onDestroyView() {
        view = null;
        getPromosInteractor.unSubscribe();
    }

    @Override
    public void checkPromos() {

        if (view == null) return;
        getPromosInteractor.execute(getPromosSubscriber());

    }

    @Override
    public void onSearchPromosTextChange(CharSequence promo) {
        if (view == null) return;
        promosAdapter.getFilter().filter(promo);
    }

    private Subscriber<ArrayList<PromosInformationView>> getPromosSubscriber() {

        return new Subscriber<ArrayList<PromosInformationView>>() {

            @Override
            public void onCompleted() {

                if (view == null) return;

                if (promosInformation == null) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(view.getPromosActivity());
                    builder.setTitle("No hay promociones");
                    builder.setMessage("Lo sentimos pero no hay promociones disponibles");
                    builder.setPositiveButton("Aceptar", (dialog, id) -> {view.getPromosActivity().finish();});
                    final AlertDialog dialog = builder.create();
                    dialog.setCancelable(false);
                    dialog.show();

                    return;
                }

                if (promosInformation.size() <= 0) {
                    final AlertDialog.Builder builder = new AlertDialog.Builder(view.getPromosActivity());
                    builder.setTitle("No hay promociones");
                    builder.setMessage("Lo sentimos pero no hay promociones disponibles");
                    builder.setPositiveButton("Aceptar", (dialog, id) -> {view.getPromosActivity().finish();});
                    final AlertDialog dialog = builder.create();
                    dialog.setCancelable(false);
                    dialog.show();

                    return;
                }

                promosAdapter = new PromosAdapter(view.getPromosContext(), promosInformation);
                view.setGvPromosAdapter(promosAdapter);
            }

            @Override
            public void onError(Throwable e) {
                if (view == null) return;

                final AlertDialog.Builder builder = new AlertDialog.Builder(view.getPromosActivity());
                builder.setTitle("Error de conexión");
                builder.setMessage(e.getMessage());
                builder.setPositiveButton("Aceptar", (dialog, id) -> {});
                final AlertDialog dialog = builder.create();
                dialog.setCancelable(false);
                dialog.show();
            }

            @Override
            public void onNext(ArrayList<PromosInformationView> promosInformationViews) {
                if (view == null) return;
                promosInformation = promosInformationViews;
            }
        };
    }

}
