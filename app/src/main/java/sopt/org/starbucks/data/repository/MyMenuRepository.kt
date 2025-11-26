package sopt.org.starbucks.data.repository

import sopt.org.starbucks.data.datasource.MyMenuDataSource
import sopt.org.starbucks.data.mapper.toDomain
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.data.model.MyMenu
import sopt.org.starbucks.data.network.handleApiResponse
import sopt.org.starbucks.data.network.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyMenuRepository
    @Inject
    constructor(
        private val myMenuDataSource: MyMenuDataSource
    ) {
        suspend fun getMyMenuList(): Result<List<MyMenu>> =
            safeApiCall {
                myMenuDataSource
                    .getMyMenuList()
                    .handleApiResponse()
                    .getOrThrow()
                    .toDomain()
            }

        suspend fun getMyMenuDetail(menuId: Long): Result<MenuDetailModel> =
            safeApiCall {
                myMenuDataSource
                    .getMyMenuDetail(menuId)
                    .handleApiResponse()
                    .getOrThrow()
                    .toDomain()
            }
    }
