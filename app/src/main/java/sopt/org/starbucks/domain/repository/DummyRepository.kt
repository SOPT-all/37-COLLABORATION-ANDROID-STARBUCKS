package sopt.org.starbucks.domain.repository

import sopt.org.starbucks.domain.model.DummyModel

interface DummyRepository {
    suspend fun dummy(): DummyModel
}
