package sopt.org.starbucks.data.service

import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.PATCH
import retrofit2.http.Path
import sopt.org.starbucks.data.dto.request.MyMenuOptionRequestDto
import sopt.org.starbucks.data.dto.response.MyMenuDetailDto
import sopt.org.starbucks.data.dto.response.MyMenuListDto
import sopt.org.starbucks.data.dto.response.MyMenuOptionResponseDto
import sopt.org.starbucks.data.network.BaseResponse

interface MyMenuService {
    @GET("/api/v1/mymenu/list")
    suspend fun getMyMenuList(): BaseResponse<MyMenuListDto>

    @GET("/api/v1/mymenu/{menuId}")
    suspend fun getMyMenuDetail(
        @Path("menuId") menuId: Long
    ): BaseResponse<MyMenuDetailDto>

    @PATCH("/api/v1/mymenu/{id}")
    suspend fun updateMyMenuOption(
        @Path("menuId") menuId: Long,
        @Body requestDto: MyMenuOptionRequestDto
    ): BaseResponse<MyMenuOptionResponseDto>
}
