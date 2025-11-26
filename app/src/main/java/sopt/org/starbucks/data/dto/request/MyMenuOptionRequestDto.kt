package sopt.org.starbucks.data.dto.request

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyMenuOptionRequestDto(
    @SerialName("isHot")
    val isHot: Boolean?,
    @SerialName("size")
    val size: String?,
    @SerialName("personalOptions")
    val personalOptions: List<PersonalOptionsRequestDto>?
)

@Serializable
data class PersonalOptionsRequestDto(
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int
)
