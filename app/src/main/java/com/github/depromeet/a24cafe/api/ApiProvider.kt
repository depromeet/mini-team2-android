package com.github.depromeet.a24cafe.api

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

fun boardApi(): apiService
        = Retrofit.Builder()
        .baseUrl("http://13.125.232.55:8080/")
        .client(OkHttpClient(provideLoggingInterceptor()))
        .addCallAdapterFactory(RxJava2CallAdapterFactory.createAsync())
        .addConverterFactory(GsonConverterFactory.create())
        .build()
        .create(apiService::class.java)

private fun OkHttpClient(
        interceptor: HttpLoggingInterceptor): OkHttpClient
        = OkHttpClient.Builder()
        .run {
            addInterceptor(interceptor)
            build()
        }

private fun provideLoggingInterceptor(): HttpLoggingInterceptor
        = HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }