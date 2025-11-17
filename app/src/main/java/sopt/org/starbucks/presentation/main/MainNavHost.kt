package sopt.org.starbucks.presentation.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import sopt.org.starbucks.core.navigtion.Home
import sopt.org.starbucks.core.navigtion.MyMenu
import sopt.org.starbucks.core.navigtion.Order
import sopt.org.starbucks.core.navigtion.Other
import sopt.org.starbucks.core.navigtion.Pay
import sopt.org.starbucks.core.navigtion.Shop
import sopt.org.starbucks.presentation.home.HomeRoute
import sopt.org.starbucks.presentation.mymenu.MyMenuRoute
import sopt.org.starbucks.presentation.order.OrderRoute

@Composable
fun MainNavHost(
    navigator: MainNavigator,
    paddingValues: PaddingValues,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navigator.navController,
        startDestination = navigator.startDestination,
        modifier = modifier.fillMaxSize()
    ) {
        composable<Home> {
            HomeRoute(
                paddingValues = paddingValues
            )
        }
        composable<Pay> { }
        composable<Order> {
            OrderRoute(
                paddingValues = paddingValues,
                navigateToMyMenu = navigator::navigateToMyMenu
            )
        }
        composable<Shop> { }
        composable<Other> { }
        composable<MyMenu> {
            MyMenuRoute(
                paddingValues = paddingValues
            )
        }
    }
}
