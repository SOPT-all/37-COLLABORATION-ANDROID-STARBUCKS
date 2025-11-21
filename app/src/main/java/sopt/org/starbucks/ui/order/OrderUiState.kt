package sopt.org.starbucks.ui.order

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.starbucks.data.model.MyMenu

data class OrderUiState(
    val myMenuList: ImmutableList<MyMenu> = persistentListOf(),
    val currentTab: OrderTab = OrderTab.ALL
)
