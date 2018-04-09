package com.github.depromeet.a24cafe.retrofit;

import com.github.depromeet.a24cafe.model.MetroContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface RetrofitService {
    @GET("/api/boards")
    Call<List<MetroContent>> getBoards();

    @POST("/api/boards")
    Call<MetroContent> postBoard(
            @Body MetroContent metroContent
    );


}
