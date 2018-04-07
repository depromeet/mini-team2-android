package com.github.depromeet.a24cafe.retrofit;

import com.github.depromeet.a24cafe.model.Test;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {
    @GET("/v2/5ac859c03100006500a57702")
    Call<Test> getTest();
}
