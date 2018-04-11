package com.github.depromeet.a24cafe.ui.contentWrite.Callback;

public interface WriteContentCallback {
    interface RetrofitCallback {
        void onSuccess();

        void onFailure();
    }
}
