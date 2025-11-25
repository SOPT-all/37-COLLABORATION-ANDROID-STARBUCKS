package sopt.org.starbucks.ui.order

import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

@HiltViewModel
class OrderViewModel
    @Inject
    constructor() : ViewModel() {
        private val _uiState = MutableStateFlow<OrderUiState>(OrderUiState())
        val uiState: StateFlow<OrderUiState> = _uiState

        fun loadMyMenuList() {
            _uiState.update {
                it.copy(
                    myMenuList = dummyMyMenu
                )
            }
        }

        fun onTabSelected(selectedTab: OrderTab) {
            _uiState.update {
                it.copy(
                    currentTab = selectedTab
                )
            }
        }
    }
