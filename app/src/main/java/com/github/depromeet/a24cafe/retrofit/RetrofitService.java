package com.github.depromeet.a24cafe.retrofit;

import com.github.depromeet.a24cafe.model.CafeContent;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface RetrofitService {
    @GET("/api/boards/{boardId}/posts")
    Call<List<CafeContent>> getContents(
            @Path("boardId") int boardId
    );

    @POST("/api/boards/{boardId}/posts")
    Call<Void> postContent(
            @Path("boardId") int boardId,
            @Body CafeContent cafeContent
    );
}
