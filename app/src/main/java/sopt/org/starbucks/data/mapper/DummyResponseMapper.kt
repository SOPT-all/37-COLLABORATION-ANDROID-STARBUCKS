package sopt.org.starbucks.data.mapper

import sopt.org.starbucks.data.dto.response.DummyResponseDto
import sopt.org.starbucks.data.model.DummyModel

fun DummyResponseDto.toDomain(): DummyModel =
    DummyModel(
        description = this.dummy + "입니다 "
    )
