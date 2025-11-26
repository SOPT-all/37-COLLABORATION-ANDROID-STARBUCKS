package sopt.org.starbucks.ui.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.repository.MyMenuRepository
import javax.inject.Inject

@HiltViewModel
class OrderViewModel
    @Inject
    constructor(
        private val myMenuRepository: MyMenuRepository
    ) : ViewModel() {
        private val _uiState = MutableStateFlow<OrderUiState>(OrderUiState())
        val uiState: StateFlow<OrderUiState> = _uiState.asStateFlow()

        fun loadMyMenuList() {
            viewModelScope.launch {
                _uiState.update { it.copy(myMenuListLoadState = UiState.Loading) }

                myMenuRepository
                    .getMyMenuList()
                    .onSuccess { myMenuList ->
                        val newState = if (myMenuList.isEmpty()) UiState.Empty else UiState.Success(myMenuList.toImmutableList())
                        _uiState.update { it.copy(myMenuListLoadState = newState) }
                    }.onFailure { t ->
                        _uiState.update {
                            it.copy(
                                myMenuListLoadState = UiState.Failure(
                                    t.message
                                        ?: "Failed to get Data"
                                )
                            )
                        }
                    }
            }
        }

        fun onTabSelected(selectedTab: OrderTab) {
            _uiState.update { it.copy(currentTab = selectedTab) }
        }
    }
