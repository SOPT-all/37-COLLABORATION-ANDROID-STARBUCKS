package sopt.org.starbucks.ui.main

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import sopt.org.starbucks.core.navigation.Home
import sopt.org.starbucks.core.navigation.MyMenu
import sopt.org.starbucks.core.navigation.Order
import sopt.org.starbucks.core.navigation.Other
import sopt.org.starbucks.core.navigation.Pay
import sopt.org.starbucks.core.navigation.Shop
import sopt.org.starbucks.ui.home.HomeRoute
import sopt.org.starbucks.ui.order.OrderRoute

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
                paddingValues = paddingValues,
                navigateToOrder = { navigator.navigate(MainTab.ORDER) }
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
        composable<MyMenu> { backStackEntry ->
            val args = backStackEntry.toRoute<MyMenu>()
//            MyMenuRoute(
//                paddingValues = paddingValues,
//                menuId = args.menuId
//            )
        }
    }
}
