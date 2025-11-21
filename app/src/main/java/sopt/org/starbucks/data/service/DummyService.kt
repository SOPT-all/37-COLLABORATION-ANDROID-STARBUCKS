package sopt.org.starbucks.data.service

import retrofit2.http.GET
import sopt.org.starbucks.data.dto.response.DummyResponseDto
import sopt.org.starbucks.data.network.BaseResponse

interface DummyService {
    @GET("/api")
    suspend fun dummy(): BaseResponse<DummyResponseDto>
}
