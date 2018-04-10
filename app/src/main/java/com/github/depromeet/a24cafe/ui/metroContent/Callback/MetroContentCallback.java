package com.github.depromeet.a24cafe.ui.metroContent.Callback;

import com.github.depromeet.a24cafe.model.MetroContent;

import java.util.List;

public interface MetroContentCallback {

    interface RetrofitCallback {
        void onConnectSuccess(List<MetroContent> items);

        void onConnectFailure();
    }
}
