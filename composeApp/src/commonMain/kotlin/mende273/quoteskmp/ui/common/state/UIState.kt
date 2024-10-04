package mende273.quoteskmp.ui.common.state

sealed interface UIState<out T> {
    data class SuccessWithData<T>(val data: T) : UIState<T>
    data object SuccessWithNoData : UIState<Nothing>
    data object ErrorRetrievingData : UIState<Nothing>
    data object Loading : UIState<Nothing>
}
