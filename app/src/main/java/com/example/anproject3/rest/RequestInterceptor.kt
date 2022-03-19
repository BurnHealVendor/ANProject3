package com.example.anproject3.rest

import okhttp3.Interceptor
import okhttp3.Response

// request to network API - build headers here
class RequestInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request().newBuilder().apply {
            addHeader("HEADER1", "FirstHeader")
            addHeader("HEADER2", "SecondHeader")
            addHeader("HEADER3", "ThirdHeader")
        }.build()

        return chain.proceed(request)
    }
}