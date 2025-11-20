package sopt.org.starbucks.ui.order

import sopt.org.starbucks.data.model.MyMenu

data class OrderUiState(
    val myMenuList: List<MyMenu> = emptyList(),
    val currentTab: OrderTab = OrderTab.ALL
)
