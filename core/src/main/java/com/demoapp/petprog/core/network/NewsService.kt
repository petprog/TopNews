package com.demoapp.petprog.core.network

import com.skydoves.sandwich.ApiResponse
import com.demoapp.petprog.core.response.ArticleResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsService {

    @GET("/v2/top-headlines")
    suspend fun headline(
        @Query("country") country: String = "us",
        @Query("sortBy") sortBy: String = "publishedAt",
    ): ApiResponse<ArticleResponse>
}