package com.github.depromeet.a24cafe.ui.metroContent.Presenter;

import android.content.Context;

import com.github.depromeet.a24cafe.ui.metroContent.Adapter.MetroAdapterContract;
import com.github.depromeet.a24cafe.ui.metroContent.Model.RetrofitModel;

import java.util.ArrayList;

public class MetroContentPresenter implements MetroContentContract.Presenter {
    private static final String TAG = MetroContentPresenter.class.getSimpleName();

    private Context context;
    private RetrofitModel model;

    private MetroContentContract.View view;
    private MetroAdapterContract.View listViewCallback;
    private MetroAdapterContract.Model listModelCallback;

    public MetroContentPresenter(Context context) {
        this.context = context;
        this.model = new RetrofitModel(context);
    }

    @Override
    public void attachView(MetroContentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void setListViewCallback(MetroAdapterContract.View listViewCallback) {
        this.listViewCallback = listViewCallback;
    }

    @Override
    public void setListModelCallback(MetroAdapterContract.Model listModelCallback) {
        this.listModelCallback = listModelCallback;
    }

    @Override
    public void loadItems(ArrayList items) {
        listModelCallback.setItems(items);
    }
}
