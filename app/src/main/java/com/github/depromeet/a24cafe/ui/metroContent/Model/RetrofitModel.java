package com.github.depromeet.a24cafe.ui.metroContent.Model;

import android.content.Context;
import android.util.Log;

import com.github.depromeet.a24cafe.R;
import com.github.depromeet.a24cafe.model.MetroContent;
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
       /* Call<MetroContent> call = retrofitService.getBoards();
        call.enqueue(new Callback<MetroContent>() {
            @Override
            public void onResponse(Call<MetroContent> call, Response<MetroContent> response) {
                MetroContent result = response.body();
                Log.d(TAG, result.getMessage());
            }

            @Override
            public void onFailure(Call<MetroContent> call, Throwable t) {
                t.printStackTrace();
            }
        });*/
    }
}
