package sopt.org.starbucks.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyMenuDto(
    @SerialName("myMenuId")
    val myMenuId: Long,
    @SerialName("myMenuName")
    val myMenuName: String,
    @SerialName("menuName")
    val menuName: String,
    @SerialName("myMenuOption")
    val myMenuOption: String,
    @SerialName("price")
    val price: Int,
    @SerialName("myMenuImage")
    val myMenuImage: String
)
