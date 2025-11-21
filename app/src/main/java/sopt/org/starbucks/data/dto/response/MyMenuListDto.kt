package sopt.org.starbucks.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyMenuListDto(
    @SerialName("myMenuList")
    val myMenuList: List<MyMenuDto>
)
