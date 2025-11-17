package sopt.org.starbucks.data.datasourceimpl

import sopt.org.starbucks.data.datasource.DummyDataSource
import sopt.org.starbucks.data.dto.response.DummyResponseDto
import sopt.org.starbucks.data.service.DummyService
import javax.inject.Inject

class DummyDataSourceImpl
    @Inject
    constructor(
        private val service: DummyService
    ) : DummyDataSource {
        override suspend fun dummy(): DummyResponseDto = service.dummy()
    }
