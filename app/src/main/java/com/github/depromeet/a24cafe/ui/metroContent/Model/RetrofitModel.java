package com.github.depromeet.a24cafe.ui.metroContent.Model;

import android.content.Context;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.CafeContent;
import com.github.depromeet.a24cafe.retrofit.RetrofitService;
import com.github.depromeet.a24cafe.ui.metroContent.Callback.MetroContentCallback;

import java.util.List;

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
    private MetroContentCallback.RetrofitCallback callback;

    public RetrofitModel(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.host))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public void setCallback(MetroContentCallback.RetrofitCallback callback) {
        this.callback = callback;
    }

    public void getContents(int boardId) {
        Call<List<CafeContent>> call = retrofitService.getContents(boardId);
        call.enqueue(new Callback<List<CafeContent>>() {
            @Override
            public void onResponse(Call<List<CafeContent>> call, Response<List<CafeContent>> response) {
                List<CafeContent> items = response.body();

                if (items == null)
                    return;

                callback.onConnectSuccess(items);
            }

            @Override
            public void onFailure(Call<List<CafeContent>> call, Throwable t) {
                t.printStackTrace();
                callback.onConnectFailure();
            }
        });
    }


}
