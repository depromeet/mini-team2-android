package com.github.depromeet.a24cafe.ui.metroContent.Presenter;

import android.content.Context;
import android.util.Log;

import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.metroContent.Adapter.MetroAdapterContract;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.MetroContentCallback;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.OnItemClickListener;
import com.github.depromeet.a24cafe.ui.metroContent.Model.RetrofitModel;

import java.util.ArrayList;
import java.util.List;

public class MetroContentPresenter implements MetroContentContract.Presenter, MetroContentCallback.RetrofitCallback,
        OnItemClickListener {
    private static final String TAG = MetroContentPresenter.class.getSimpleName();

    private Context context;
    private RetrofitModel model;

    private MetroContentContract.View view;
    private MetroAdapterContract.View listViewCallback;
    private MetroAdapterContract.Model listModelCallback;

    public MetroContentPresenter(Context context) {
        this.context = context;
        this.model = new RetrofitModel(context);
        this.model.setCallback(this);
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
        this.listViewCallback.setOnClickListener(this);
    }

    @Override
    public void setListModelCallback(MetroAdapterContract.Model listModelCallback) {
        this.listModelCallback = listModelCallback;
    }

    @Override
    public void loadItems(ArrayList items) {
        listModelCallback.setItems(items);
    }

    @Override
    public void connect(int boardId) {
        model.getContents(boardId);
    }

    @Override
    public void onConnectSuccess(List<CafeContent> items) {
        ArrayList list = new ArrayList(items);
        loadItems(list);
    }

    @Override
    public void onConnectFailure() {
        view.toast("서버연결 오류입니다.");
    }

    @Override
    public void onItemClick(CafeContent item, int position) {
        Log.d(TAG, "click " + position);
        view.startContentActivity(item);
    }
}
