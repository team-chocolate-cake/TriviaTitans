package com.chocolate.triviatitans.data.repository

open class ApiThrowable(message: String?): Throwable(message)
class UnauthorizedThrowable: ApiThrowable("Unauthorized")
class NoNetworkThrowable: ApiThrowable("No Network")
class ParsingThrowable:ApiThrowable("Parsing Error")