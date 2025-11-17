package sopt.org.starbucks.data.service

import retrofit2.http.GET
import sopt.org.starbucks.data.dto.response.DummyResponseDto

interface DummyService {
    @GET("/api")
    suspend fun dummy(): DummyResponseDto
}
