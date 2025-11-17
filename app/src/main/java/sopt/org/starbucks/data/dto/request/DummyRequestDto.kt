package sopt.org.starbucks.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DummyRequestDto(
    @SerialName("dummy")
    val dummy: String
)
