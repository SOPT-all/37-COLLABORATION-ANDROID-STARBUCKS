package sopt.org.starbucks.data.network

import retrofit2.HttpException
import java.net.UnknownHostException
import kotlin.coroutines.cancellation.CancellationException

internal suspend fun <T> safeApiCall(block: suspend () -> T): Result<T> =
    try {
        Result.success(block())
    } catch (e: HttpException) {
        Result.failure(parseHttpException(e))
    } catch (e: UnknownHostException) {
        Result.failure(Exception("Network Error: ${e.message}"))
    } catch (e: CancellationException) {
        throw e
    } catch (e: Exception) {
        Result.failure(e)
    }

fun <T> BaseResponse<T>.handleApiResponse(): Result<T> =
    if (this.code in 200..299) {
        if (this.data == null) {
            Result.failure(Exception("Successful response but data field was null."))
        } else {
            Result.success(this.data)
        }
    } else {
        Result.failure(Exception("Unknown error : ${this.msg}"))
    }
