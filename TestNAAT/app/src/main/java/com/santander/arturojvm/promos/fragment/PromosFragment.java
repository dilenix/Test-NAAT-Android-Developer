package com.santander.arturojvm.promos.fragment;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import com.santander.arturojvm.R;
import com.santander.arturojvm.promos.PromosActivity;
import com.santander.arturojvm.promos.adapter.PromosAdapter;
import com.santander.arturojvm.promos.presenter.PromosPresenter;
import com.santander.arturojvm.promos.presenter.PromosPresenterImpl;
import com.santander.arturojvm.promos.view.PromosView;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnTextChanged;

/**
 * Created by arturo on 15/02/17.
 */

public class PromosFragment extends Fragment implements PromosView {

    public static final String TAG = PromosFragment.class.getName();

    @BindView(R.id.gv_promos)
    GridView gvPromos;

    @BindView(R.id.et_search_promos)
    EditText etSearchPromos;

    private PromosPresenter presenter;

    public static PromosFragment newInstance() {
        return new PromosFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_promos, container, false);
        ButterKnife.bind(this, view);
        initPropierties();
        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        presenter.onDestroyView();
    }


    @Override
    public Context getPromosContext() {
        return getPromosActivity().getApplicationContext();
    }

    @Override
    public Activity getPromosActivity() {
        return (PromosActivity) getActivity();
    }

    @Override
    public FragmentManager getSupportFragmentManager() {
        return ((PromosActivity) getActivity()).getSupportFragmentManager();
    }

    @Override
    public void showToast(String message) {
        Toast.makeText(getPromosContext(), message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void setGvPromosAdapter(PromosAdapter adapter) {
        gvPromos.setAdapter(adapter);
    }

    @Override
    public GridView getGvPromos() {
        return gvPromos;
    }

    @OnTextChanged(R.id.et_search_promos)
    public void onSearchPromosTextChange(CharSequence text) {
        presenter.onSearchPromosTextChange(text);
    }

    private void initPropierties() {
        presenter = new PromosPresenterImpl();
        presenter.onCreateView(this);
        presenter.checkPromos();
    }
}
