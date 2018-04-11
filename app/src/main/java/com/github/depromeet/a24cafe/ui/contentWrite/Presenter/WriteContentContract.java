package com.github.depromeet.a24cafe.ui.contentWrite.Presenter;

import com.github.depromeet.a24cafe.model.CafeContent;

public interface WriteContentContract {
    interface View {
        void toast(final String msg);

        void finishActivity();
    }
    
    interface Model {
        void attachView(View v);

        void detachView();

        void connect(CafeContent content);
    }
}
