package sopt.org.starbucks.data.repositoryimpl

import sopt.org.starbucks.data.datasource.DummyDataSource
import sopt.org.starbucks.data.mapper.toDomain
import sopt.org.starbucks.domain.model.DummyModel
import sopt.org.starbucks.domain.repository.DummyRepository
import javax.inject.Inject

class DummyRepositoryImpl
    @Inject
    constructor(
        private val dummyDataSource: DummyDataSource
    ) : DummyRepository {
        override suspend fun dummy(): DummyModel = dummyDataSource.dummy().toDomain()
    }
