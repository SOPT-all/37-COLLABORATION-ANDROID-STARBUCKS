package sopt.org.starbucks.data.datasource

import sopt.org.starbucks.data.dto.response.MyHomeMenuListDto
import sopt.org.starbucks.data.network.BaseResponse
import sopt.org.starbucks.data.service.MyHomeMenuService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyHomeMenuDataSource
    @Inject
    constructor(
        private val service: MyHomeMenuService
    ) {
        suspend fun getMyHomeMenu(): BaseResponse<MyHomeMenuListDto> = service.getMyHomeMenu()
    }
