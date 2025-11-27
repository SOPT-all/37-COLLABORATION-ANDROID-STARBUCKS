package sopt.org.starbucks.ui.mymenu

import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.persistentListOf
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.MenuDetailModel
import sopt.org.starbucks.data.model.PersonalOption
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType

data class MyMenuUiState(
    val menuLoadState: UiState<MenuDetailModel> = UiState.Init,
    val selectedTab: TabType = TabType.ICED,
    val selectedSize: DrinkSize = DrinkSize.TALL,
    val isPersonalCupChecked: Boolean = false,
    val optionList: ImmutableList<PersonalOption> = persistentListOf(),
    val showDialog: Boolean = false,
    val dialogType: DialogType = DialogType.DELETE,
    val selectedOption: PersonalOption? = null,
    val totalPrice: Int = 0
)
