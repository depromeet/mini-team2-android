package com.github.depromeet.a24cafe.ui.contentWrite.Model;

import android.content.Context;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.retrofit.RetrofitService;
import com.github.depromeet.a24cafe.ui.contentWrite.Callback.WriteContentCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitModel {
    private static final String TAG = RetrofitModel.class.getSimpleName();
    private Retrofit retrofit;
    private Context context;
    private RetrofitService retrofitService;
    private WriteContentCallback.RetrofitCallback callback;

    public RetrofitModel(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.host))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public void setCallback(WriteContentCallback.RetrofitCallback callback) {
        this.callback = callback;
    }

    public void writeToServer(CafeContent content) {
        Call<Void> call = retrofitService.postContent(1, content);
        call.enqueue(new Callback<Void>() {
            @Override
            public void onResponse(Call<Void> call, Response<Void> response) {
                callback.onSuccess();
            }

            @Override
            public void onFailure(Call<Void> call, Throwable t) {
                t.printStackTrace();
                callback.onFailure();
            }
        });
    }
}