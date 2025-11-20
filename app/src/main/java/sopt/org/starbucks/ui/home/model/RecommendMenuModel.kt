package sopt.org.starbucks.ui.home.model

import androidx.annotation.DrawableRes

data class RecommendMenuModel(
    val id: Long,
    @DrawableRes val image: Int,
    val name: String,
)
