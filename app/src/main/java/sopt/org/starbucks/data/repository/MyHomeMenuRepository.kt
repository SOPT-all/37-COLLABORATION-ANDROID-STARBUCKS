package sopt.org.starbucks.data.repository

import sopt.org.starbucks.data.datasource.MyHomeMenuDataSource
import sopt.org.starbucks.data.mapper.toDomain
import sopt.org.starbucks.data.model.MyHomeMenu
import sopt.org.starbucks.data.network.handleApiResponse
import sopt.org.starbucks.data.network.safeApiCall
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MyHomeMenuRepository
    @Inject
    constructor(
        private val dataSource: MyHomeMenuDataSource
    ) {
        suspend fun getMyHomeMenu(): Result<List<MyHomeMenu>> =
            safeApiCall {
                dataSource
                    .getMyHomeMenu()
                    .handleApiResponse()
                    .getOrThrow()
                    .toDomain()
            }
    }
