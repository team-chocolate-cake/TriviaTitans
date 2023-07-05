package com.chocolate.triviatitans.data.remote

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TriviaTitansInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val url = originalRequest.url.newBuilder()
            .build()

        val requestBuilder = originalRequest.newBuilder().url(url)

        return chain.proceed(requestBuilder.build())
    }
}