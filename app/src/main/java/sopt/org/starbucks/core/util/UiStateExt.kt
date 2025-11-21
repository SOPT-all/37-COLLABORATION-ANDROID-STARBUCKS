package sopt.org.starbucks.core.util

import sopt.org.starbucks.core.state.UiState

inline fun <T> UiState<T>.onSuccess(block: (T) -> Unit) {
    if (this is UiState.Success) {
        block(data)
    }
}
