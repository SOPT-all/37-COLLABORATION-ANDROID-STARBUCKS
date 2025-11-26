package sopt.org.starbucks.ui.order

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.model.MyMenu
import sopt.org.starbucks.data.repository.MyMenuRepository
import javax.inject.Inject

@HiltViewModel
class OrderViewModel
    @Inject
    constructor(
        private val myMenuRepository: MyMenuRepository
    ) : ViewModel() {
        private val _myMenuListLoadState = MutableStateFlow<UiState<List<MyMenu>>>(UiState.Init)
        private val _currentTab = MutableStateFlow(OrderTab.ALL)

        val uiState: StateFlow<OrderUiState> = combine(
            _myMenuListLoadState,
            _currentTab
        ) { loadState, currentTab ->
            val filteredLoadState = when (loadState) {
                is UiState.Success -> {
                    val originalList = loadState.data
                    val filteredList = if (currentTab == OrderTab.ALL) {
                        originalList
                    } else {
                        originalList.filter { it.category == currentTab }
                    }

                    if (filteredList.isEmpty()) {
                        UiState.Empty
                    } else {
                        UiState.Success(filteredList.toImmutableList())
                    }
                }
                is UiState.Loading -> UiState.Loading
                is UiState.Failure -> UiState.Failure(loadState.message)
                is UiState.Empty -> UiState.Empty
                is UiState.Init -> UiState.Init
            }

            OrderUiState(
                myMenuListLoadState = filteredLoadState,
                currentTab = currentTab
            )
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = OrderUiState()
        )

        fun loadMyMenuList() {
            viewModelScope.launch {
                if (_myMenuListLoadState.value !is UiState.Success) {
                    _myMenuListLoadState.value = UiState.Loading
                }
                myMenuRepository
                    .getMyMenuList()
                    .onSuccess { myMenuList ->
                        _myMenuListLoadState.value = if (myMenuList.isEmpty()) {
                            UiState.Empty
                        } else {
                            UiState.Success(myMenuList)
                        }
                    }.onFailure { t ->
                        _myMenuListLoadState.value = UiState.Failure(t.message ?: "Failed to get Data")
                    }
            }
        }

        fun onTabSelected(selectedTab: OrderTab) {
            _currentTab.value = selectedTab
        }
    }
