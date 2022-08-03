package com.demoapp.petprog.core.network

import android.content.Context
import com.demoapp.petprog.core.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class RequestInterceptor(val context: Context) : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder().addQueryParameter("apiKey", BuildConfig.API_KEY).build()
        val response = originalRequest.newBuilder().url(url).build()
        return chain.proceed(response)
    }
}