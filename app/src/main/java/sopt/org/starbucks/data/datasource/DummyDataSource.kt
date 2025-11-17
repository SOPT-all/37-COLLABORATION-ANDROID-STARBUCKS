package sopt.org.starbucks.data.datasource

import sopt.org.starbucks.data.dto.response.DummyResponseDto

interface DummyDataSource {
    suspend fun dummy(): DummyResponseDto
}
