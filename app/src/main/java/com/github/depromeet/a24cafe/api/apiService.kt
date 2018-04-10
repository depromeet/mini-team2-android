package com.github.depromeet.a24cafe.api

import io.reactivex.Observable
import retrofit2.http.GET

interface apiService {

    // 메인 액티비티 리스트
    @GET("api/boards")
    fun getMainBoardList(): Observable<mainItem>

    data class mainItem(val id: Int, val name: String)

}