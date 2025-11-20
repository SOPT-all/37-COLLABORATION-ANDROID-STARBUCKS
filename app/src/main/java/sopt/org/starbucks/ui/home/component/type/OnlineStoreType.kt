package sopt.org.starbucks.ui.home.component.type

import androidx.annotation.DrawableRes
import sopt.org.starbucks.R

enum class OnlineStoreType(
    @DrawableRes val image: Int,
    val date: String? = null
) {
    SSGDAY(
        image = R.drawable.img_home_online_01,
        date = "2025. 10. 30 (목) - 11.9 (일)"
    ),
    HEART(
        image = R.drawable.img_home_online_02
    )
}
