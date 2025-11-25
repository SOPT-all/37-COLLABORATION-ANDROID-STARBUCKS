package sopt.org.starbucks.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.collections.immutable.toImmutableList
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import sopt.org.starbucks.core.state.UiState
import sopt.org.starbucks.data.repository.MyHomeMenuRepository
import javax.inject.Inject

@HiltViewModel
class HomeViewModel
    @Inject
    constructor(
        private val repository: MyHomeMenuRepository
    ) : ViewModel() {
        private val _uiState = MutableStateFlow(HomeUiState())
        val uiState: StateFlow<HomeUiState> = _uiState

        fun loadQuickOrder() {
            viewModelScope.launch {
                _uiState.update { it.copy(quickOrderList = UiState.Loading) }

                repository
                    .getMyHomeMenu()
                    .onSuccess { list ->
                        val state = if (list.isEmpty()) UiState.Empty else UiState.Success(list.toImmutableList())
                        _uiState.update { it.copy(quickOrderList = state) }
                    }.onFailure { t ->
                        _uiState.update {
                            it.copy(quickOrderList = UiState.Failure(t.message ?: "Failed"))
                        }
                    }
            }
        }
    }
