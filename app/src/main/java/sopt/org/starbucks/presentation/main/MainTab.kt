package sopt.org.starbucks.presentation.main

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import sopt.org.starbucks.R
import sopt.org.starbucks.core.designsystem.theme.defaultStarbucksColors
import sopt.org.starbucks.core.navigtion.Home
import sopt.org.starbucks.core.navigtion.MainTabRoute
import sopt.org.starbucks.core.navigtion.Order
import sopt.org.starbucks.core.navigtion.Other
import sopt.org.starbucks.core.navigtion.Pay
import sopt.org.starbucks.core.navigtion.Shop

enum class MainTab(
    @DrawableRes val iconResId: Int,
    @StringRes val label: Int,
    val route: MainTabRoute,
    val defaultColor: Color = defaultStarbucksColors.gray500,
    val selectedColor: Color = defaultStarbucksColors.green500
) {
    HOME(
        iconResId = R.drawable.ic_home,
        label = R.string.home,
        route = Home
    ),
    PAY(
        iconResId = R.drawable.ic_pay,
        label = R.string.pay,
        route = Pay
    ),
    ORDER(
        iconResId = R.drawable.ic_order,
        label = R.string.order,
        route = Order
    ),
    SHOP(
        iconResId = R.drawable.ic_shop,
        label = R.string.shop,
        route = Shop
    ),
    OTHER(
        iconResId = R.drawable.ic_other,
        label = R.string.other,
        route = Other
    );

    companion object {
        @Composable
        fun contains(predicate: @Composable (MainTabRoute) -> Boolean): Boolean = entries.map { it.route }.any { predicate(it) }
    }
}
