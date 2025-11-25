package sopt.org.starbucks.ui.home

import kotlinx.collections.immutable.ImmutableList
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.MyHomeMenu

data class HomeUiState(
    val quickOrderList: UiState<ImmutableList<MyHomeMenu>> = UiState.Init
)
