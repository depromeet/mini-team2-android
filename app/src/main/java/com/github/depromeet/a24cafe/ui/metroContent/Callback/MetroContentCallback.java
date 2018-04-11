package com.github.depromeet.a24cafe.ui.metroContent.Callback;

import com.github.depromeet.a24cafe.model.CafeContent;

import java.util.List;

public interface MetroContentCallback {

    interface RetrofitCallback {
        void onConnectSuccess(List<CafeContent> items);

        void onConnectFailure();
    }
}
