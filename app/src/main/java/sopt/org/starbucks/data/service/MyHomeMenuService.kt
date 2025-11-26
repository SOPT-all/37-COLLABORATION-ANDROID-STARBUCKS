package sopt.org.starbucks.data.service

import retrofit2.http.GET
import sopt.org.starbucks.data.dto.response.MyHomeMenuListDto
import sopt.org.starbucks.data.network.BaseResponse

interface MyHomeMenuService {
    @GET("/api/v1/mymenu/home")
    suspend fun getMyHomeMenu(): BaseResponse<MyHomeMenuListDto>
}
