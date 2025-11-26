package sopt.org.starbucks.ui.mymenu

enum class OptionType(
    val option: String,
    val price: Int?
) {
    PINK(
        option = "핑크 리치 보바 없음",
        price = null
    ),
    ROSE(
        option = "로즈마리 많이",
        price = null
    ),
    WHIP(
        option = "일반휘핑 많이",
        price = 800
    )
}
