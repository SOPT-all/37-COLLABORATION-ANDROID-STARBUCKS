package sopt.org.starbucks.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyMenuOptionResponseDto(
    @SerialName("myMenuId")
    val myMenuId: Long,
    @SerialName("isHot")
    val isHot: Boolean?,
    @SerialName("size")
    val size: String?,
    @SerialName("summary")
    val summary: String,
    @SerialName("personalOptions")
    val personalOptions: List<PersonalOptionsDto>?
)

@Serializable
data class PersonalOptionsDto(
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int
)
