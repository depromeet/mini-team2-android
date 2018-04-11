package com.github.depromeet.a24cafe.ui.contentWrite.Presenter;

import android.content.Context;

import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.ui.contentWrite.Callback.WriteContentCallback;
import com.github.depromeet.a24cafe.ui.contentWrite.Model.RetrofitModel;

public class WriteContentPresenter implements WriteContentContract.Model, WriteContentCallback.RetrofitCallback {
    private static final String TAG = WriteContentPresenter.class.getSimpleName();

    private Context context;
    private RetrofitModel retrofitModel;

    private WriteContentContract.View view;

    public WriteContentPresenter(Context context) {
        this.context = context;
        this.retrofitModel = new RetrofitModel(context);
        retrofitModel.setCallback(this);
    }

    @Override
    public void attachView(WriteContentContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
        this.view = null;
    }

    @Override
    public void connect(CafeContent content) {
        retrofitModel.writeToServer(content);
    }

    @Override
    public void onSuccess() {
        view.toast("작성 되었습니다");
        view.finishActivity();
    }

    @Override
    public void onFailure() {
        view.toast("서버연결 오류입니다");
        view.finishActivity();
    }
}
