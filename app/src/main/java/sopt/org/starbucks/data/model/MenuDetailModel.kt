package sopt.org.starbucks.data.model

data class MenuDetailModel(
    val id: String = "",
    val koreanName: String = "",
    val englishName: String = "",
    val description: String = "",
    val imageUrl: String? = null,
    val price: Int = 0,
    val isNew: Boolean = false,
    val notices: List<String> = emptyList()
)
