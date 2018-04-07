package com.github.depromeet.a24cafe.ui.test.Model;

import android.content.Context;
import android.util.Log;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.Test;
import com.github.depromeet.a24cafe.retrofit.RetrofitService;

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

    public RetrofitModel(Context context) {
        this.context = context;
        retrofit = new Retrofit.Builder()
                .baseUrl(context.getString(R.string.host))
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        retrofitService = retrofit.create(RetrofitService.class);
    }

    public void getTest() {
        Call<Test> call = retrofitService.getTest();
        call.enqueue(new Callback<Test>() {
            @Override
            public void onResponse(Call<Test> call, Response<Test> response) {
                Test result = response.body();
                Log.d(TAG, result.getMessage());
            }

            @Override
            public void onFailure(Call<Test> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
