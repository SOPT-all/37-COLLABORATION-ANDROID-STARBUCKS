package sopt.org.starbucks.data.repository

import sopt.org.starbucks.data.datasource.DummyDataSource
import sopt.org.starbucks.data.mapper.toDomain
import sopt.org.starbucks.data.model.DummyModel
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DummyRepository
    @Inject
    constructor(
        private val dummyDataSource: DummyDataSource
    ) {
        suspend fun dummy(): DummyModel = dummyDataSource.dummy().toDomain()
    }
