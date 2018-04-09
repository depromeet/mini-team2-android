package com.github.depromeet.a24cafe.ui.metroContent.Presenter;

import com.github.depromeet.a24cafe.ui.metroContent.Adapter.MetroAdapterContract;

import java.util.ArrayList;

public interface MetroContentContract {
    interface View {
        void toast(String msg);
    }

    interface Presenter {
        void attachView(View view);

        void detachView();

        void setListViewCallback(MetroAdapterContract.View callback);

        void setListModelCallback(MetroAdapterContract.Model callback);

        void loadItems(ArrayList items);
    }
}