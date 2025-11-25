package sopt.org.starbucks.ui.mymenu

import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType

data class EditMenuUiState(
    val menu: MenuDetailModel = MenuDetailModel(),
    val selectedTab: TabType = TabType.ICED,
    val selectedSize: DrinkSize = DrinkSize.TALL,
    val isPersonalCupChecked: Boolean = false
)
