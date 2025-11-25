package sopt.org.starbucks.core.navigation

import kotlinx.serialization.Serializable

sealed interface Route

sealed interface MainTabRoute : Route

@Serializable
data object Home : MainTabRoute

@Serializable
data object Pay : MainTabRoute

@Serializable
data object Order : MainTabRoute

@Serializable
data object Shop : MainTabRoute

@Serializable
data object Other : MainTabRoute

@Serializable
data class MyMenu(
    val menuId: Long
) : Route
