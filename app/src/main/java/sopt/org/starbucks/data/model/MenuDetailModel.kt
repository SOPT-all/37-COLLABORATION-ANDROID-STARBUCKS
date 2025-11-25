package sopt.org.starbucks.data.model

data class MenuDetailModel(
    val myMenuId: Long = 0,
    val categoryName: String = "",
    val hotMenuKr: String = "",
    val hotMenuEng: String = "",
    val hotMenuImageUrl: String = "",
    val iceMenuKr: String = "",
    val iceMenuEng: String = "",
    val iceMenuImageUrl: String = "",
    val info: String = "",
    val price: Int = 0,
    val count: Int = 0,
    val isHot: Boolean = true,
    val size: String = "TALL",
    val sizePrices: SizePrices = SizePrices(),
    val personalOptions: List<PersonalOption> = emptyList(),
    val summary: String = "",
    val isNew: Boolean = false,
    val notices: List<String> = emptyList()
)

data class SizePrices(
    val tall: Int = 0,
    val grande: Int = 0,
    val venti: Int = 0
)

data class PersonalOption(
    val name: String = "",
    val price: Int = 0
)
