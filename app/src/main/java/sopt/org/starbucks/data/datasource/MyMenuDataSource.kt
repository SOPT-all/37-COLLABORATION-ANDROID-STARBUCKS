package sopt.org.starbucks.data.datasource

import sopt.org.starbucks.data.dto.response.MyMenuDetailDto
import sopt.org.starbucks.data.dto.response.MyMenuListDto
import sopt.org.starbucks.data.network.BaseResponse
import sopt.org.starbucks.data.service.MyMenuService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyMenuDataSource
    @Inject
    constructor(
        private val myMenuService: MyMenuService
    ) {
        suspend fun getMyMenuList(): BaseResponse<MyMenuListDto> = myMenuService.getMyMenuList()

        suspend fun getMyMenuDetail(menuId: Long): BaseResponse<MyMenuDetailDto> = myMenuService.getMyMenuDetail(menuId)
    }
