package com.github.depromeet.a24cafe.ui.test.Presenter;

import android.content.Context;

import com.github.depromeet.a24cafe.ui.test.Model.RetrofitModel;

public class ContentPresenter implements ContentContract.Presenter {
    private static final String TAG = ContentPresenter.class.getSimpleName();
    private ContentContract.View view;
    private Context context;
    private RetrofitModel model;

    public ContentPresenter(Context context) {
        this.context = context;
        this.model = new RetrofitModel(context);
        model.getTest();
    }

    @Override
    public void attachView(ContentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }
}
