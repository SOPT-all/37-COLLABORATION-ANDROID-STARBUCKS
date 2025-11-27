package sopt.org.starbucks.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyHomeMenuListDto(
    @SerialName("myMenuList")
    val myMenuList: List<MyHomeMenuDto>
)

@Serializable
data class MyHomeMenuDto(
    @SerialName("myMenuId")
    val myMenuId: Long,
    @SerialName("myMenuName")
    val myMenuName: String,
    @SerialName("myMenuOption")
    val myMenuOption: String,
    @SerialName("myMenuImage")
    val myMenuImage: String
)
