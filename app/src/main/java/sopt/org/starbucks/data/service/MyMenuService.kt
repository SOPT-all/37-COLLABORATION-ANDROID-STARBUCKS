package sopt.org.starbucks.data.service

import retrofit2.http.GET
import sopt.org.starbucks.data.dto.response.MyMenuListDto
import sopt.org.starbucks.data.network.BaseResponse

interface MyMenuService {
    @GET("/api/v1/mymenu/list")
    suspend fun getMyMenuList(): BaseResponse<MyMenuListDto>
}
