package sopt.org.starbucks.ui.mymenu

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.repository.MyMenuRepository
import sopt.org.starbucks.ui.mymenu.component.DrinkSize
import sopt.org.starbucks.ui.mymenu.component.TabType
import javax.inject.Inject

@HiltViewModel
class MyMenuViewModel
    @Inject
    constructor(
        private val myMenuRepository: MyMenuRepository
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(MyMenuUiState())
        val uiState = _uiState.asStateFlow()

        fun loadMenu(menuId: Long) {
            viewModelScope.launch {
                _uiState.update { it.copy(menuLoadState = UiState.Loading) }

                myMenuRepository
                    .getMyMenuDetail(menuId)
                    .onSuccess { menu ->
                        _uiState.update {
                            it.copy(
                                menuLoadState = UiState.Success(menu),
                                selectedTab = if (menu.isHot) TabType.HOT else TabType.ICED,
                                selectedSize = when (menu.size) {
                                    "TALL" -> DrinkSize.TALL
                                    "GRANDE" -> DrinkSize.GRANDE
                                    "VENTI" -> DrinkSize.VENTI
                                    else -> DrinkSize.TALL
                                }
                            )
                        }
                    }.onFailure { t ->
                        _uiState.update {
                            it.copy(
                                menuLoadState = UiState.Failure(
                                    t.message ?: "Failed to load menu"
                                )
                            )
                        }
                    }
            }
        }

        fun selectTab(tab: TabType) {
            _uiState.update { it.copy(selectedTab = tab) }
        }

        fun selectSize(size: DrinkSize) {
            _uiState.update { it.copy(selectedSize = size) }
        }

        fun togglePersonalCup() {
            _uiState.update { it.copy(isPersonalCupChecked = !it.isPersonalCupChecked) }
        }
    }
