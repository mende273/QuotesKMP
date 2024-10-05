package mende273.quoteskmp.data.mapper

import mende273.quoteskmp.ui.common.state.UIState

fun <T> List<T>?.toUiState(): UIState<List<T>> {
    return when (this) {
        null -> UIState.ErrorRetrievingData
        else -> {
            if (this.isEmpty()) {
                UIState.SuccessWithNoData
            } else {
                UIState.SuccessWithData(this)
            }
        }
    }
}
