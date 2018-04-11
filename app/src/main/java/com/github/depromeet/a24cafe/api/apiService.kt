package com.github.depromeet.a24cafe.api

import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path

interface apiService {

    // 메인 액티비티 리스트
    @GET("api/boards")
    fun getMainBoardList(): Observable<MutableList<mainItem>>

    data class mainItem(val id: Int, val name: String, val subwayId: Int, val image: String?)

    // Content Activity 정보
    @GET("api//boards/{boardId}/posts/{postId}")
    fun getContentData(@Path("boardId") boardId: Int,
                       @Path("postId") postId: Int): Observable<contentItem>

    data class contentItem(val id: Int, val boardId: Int, val title: String, val content: String, val latitude: Double, val longitude: Double, val createdAt: String, val openedAt: String,
                           val closedAt: String, val phone: String, val nearestExit: String)

}