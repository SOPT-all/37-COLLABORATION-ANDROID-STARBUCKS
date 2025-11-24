package sopt.org.starbucks.ui.mymenu

import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType

data class EditMenuUiState(
    val menu: MenuDetail = MenuDetail(),
    val selectedTab: TabType = TabType.ICED,
    val selectedSize: DrinkSize = DrinkSize.TALL,
    val isPersonalCupChecked: Boolean = false
)
