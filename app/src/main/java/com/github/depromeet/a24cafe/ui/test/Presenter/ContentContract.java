package com.github.depromeet.a24cafe.ui.test.Presenter;

public interface ContentContract {
    interface View {
        void toast(String msg);
    }

    interface Presenter {
        void attachView(View view);
        void detachView();
    }
}
