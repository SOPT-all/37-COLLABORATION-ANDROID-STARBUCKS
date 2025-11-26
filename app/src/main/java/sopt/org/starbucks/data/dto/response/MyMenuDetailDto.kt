package sopt.org.starbucks.data.dto.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class MyMenuDetailDto(
    @SerialName("categoryName")
    val categoryName: String,
    @SerialName("myMenuId")
    val myMenuId: Long,
    @SerialName("hotMenuKr")
    val hotMenuKr: String,
    @SerialName("hotMenuEng")
    val hotMenuEng: String,
    @SerialName("hotMenuImageUrl")
    val hotMenuImageUrl: String,
    @SerialName("iceMenuKr")
    val iceMenuKr: String,
    @SerialName("iceMenuEng")
    val iceMenuEng: String,
    @SerialName("iceMenuImageUrl")
    val iceMenuImageUrl: String,
    @SerialName("info")
    val info: String,
    @SerialName("price")
    val price: Int,
    @SerialName("count")
    val count: Int,
    @SerialName("isHot")
    val isHot: Boolean,
    @SerialName("size")
    val size: String,
    @SerialName("sizePrices")
    val sizePrices: SizePricesDto,
    @SerialName("personalOptions")
    val personalOptions: List<PersonalOptionDto>,
    @SerialName("summary")
    val summary: String
)

@Serializable
data class SizePricesDto(
    @SerialName("Tall")
    val tall: Int,
    @SerialName("Grande")
    val grande: Int,
    @SerialName("Venti")
    val venti: Int
)

@Serializable
data class PersonalOptionDto(
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Int
)
