package sopt.org.starbucks.ui.mymenu

import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType

data class MyMenuUiState(
    val menuLoadState: UiState<MenuDetailModel> = UiState.Init,
    val selectedTab: TabType = TabType.ICED,
    val selectedSize: DrinkSize = DrinkSize.TALL,
    val isPersonalCupChecked: Boolean = false
)
