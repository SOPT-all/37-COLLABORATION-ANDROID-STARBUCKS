package sopt.org.starbucks.ui.order

import kotlinx.collections.immutable.ImmutableList
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.MyMenu

data class OrderUiState(
    val myMenuListLoadState: UiState<ImmutableList<MyMenu>> = UiState.Init,
    val currentTab: OrderTab = OrderTab.ALL
)
