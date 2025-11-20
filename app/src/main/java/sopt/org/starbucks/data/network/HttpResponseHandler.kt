package sopt.org.starbucks.data.network

import kotlinx.serialization.json.Json
import retrofit2.HttpException

private val json = Json { ignoreUnknownKeys = true }

fun parseHttpException(e: HttpException): Exception =
    try {
        val errorBody = e.response()?.errorBody()?.string()

        val errorResponse = errorBody?.let {
            json.decodeFromString<BaseResponse<Unit>>(it)
        }

        if (errorResponse != null) {
            when (errorResponse.code) {
                404 -> Exception("Not Found : ${errorResponse.msg}")
                405 -> Exception("Wrong Request : ${errorResponse.msg}")
                500 -> Exception("Internal Server Error : ${errorResponse.msg}")
                else -> Exception("Server Error (${errorResponse.code}) : ${errorResponse.msg}")
            }
        } else {
            Exception("Server Error : ${e.code()} ${e.message()}")
        }
    } catch (parsingException: Exception) {
        Exception("Failed to parse error response : ${e.message}", parsingException)
    }
