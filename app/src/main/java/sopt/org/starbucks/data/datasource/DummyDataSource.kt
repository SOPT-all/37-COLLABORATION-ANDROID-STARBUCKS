package sopt.org.starbucks.data.datasource

import sopt.org.starbucks.data.dto.response.DummyResponseDto
import sopt.org.starbucks.data.service.DummyService
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyDataSource
    @Inject
    constructor(
        private val dummyService: DummyService
    ) {
        suspend fun dummy(): DummyResponseDto = dummyService.dummy()
    }
