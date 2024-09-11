package com.manasa.data.network

import retrofit2.http.GET

interface FeatureApiService {

    @GET("/feature/endpoint")
    suspend fun getFeature()
}