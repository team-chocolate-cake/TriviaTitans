package com.chocolate.triviatitans.data.repository

import retrofit2.Response
import java.net.UnknownHostException

abstract class BaseRepository {

    protected suspend fun <T> wrapApiCall(call: suspend () -> Response<T>): T {
        return try {
            val result = call()
            if (result.code() == UNAUTHORIZED_CODE) {
                throw UnauthorizedThrowable()
            }
            result.body() ?: throw ParsingThrowable()
        } catch (e: UnknownHostException) {
            throw NoNetworkThrowable()
        } catch (e: Exception) {
            throw ApiThrowable(e.message)
        }
    }

    private companion object {
        const val UNAUTHORIZED_CODE = 401
    }
}