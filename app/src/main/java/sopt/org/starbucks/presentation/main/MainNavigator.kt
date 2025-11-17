package sopt.org.starbucks.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.navigation.NavDestination
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navOptions
import sopt.org.starbucks.core.navigtion.Home
import sopt.org.starbucks.core.navigtion.MyMenu
import sopt.org.starbucks.core.navigtion.Order
import sopt.org.starbucks.core.navigtion.Other
import sopt.org.starbucks.core.navigtion.Pay
import sopt.org.starbucks.core.navigtion.Shop

class MainNavigator(
    val navController: NavHostController
) {
    val startDestination = Home

    private val currentDestination: NavDestination?
        @Composable get() = navController
            .currentBackStackEntryAsState()
            .value
            ?.destination

    val currentTab: MainTab?
        @Composable get() = MainTab.entries.find { tab ->
            when (tab.route) {
                else -> currentDestination?.route == tab.route::class.qualifiedName
            }
        }

    fun navigate(tab: MainTab) {
        val navOptions = navOptions {
            navController.currentDestination?.route?.let {
                popUpTo(it) {
                    inclusive = true
                }
            }
            launchSingleTop = true
            restoreState = true
        }

        val route = when (tab) {
            MainTab.HOME -> Home
            MainTab.PAY -> Pay
            MainTab.ORDER -> Order
            MainTab.SHOP -> Shop
            MainTab.OTHER -> Other
        }

        navController.navigate(route, navOptions)
    }

    @Composable
    fun shouldShowBottomBar() =
        MainTab.contains {
            currentDestination?.route == it::class.qualifiedName
        }

    fun navigateToMyMenu() {
        navController.navigate(MyMenu)
    }
}

@Composable
fun rememberMainNavigator(navController: NavHostController = rememberNavController()): MainNavigator =
    remember(navController) {
        MainNavigator(navController)
    }
