package mende273.quoteskmp.ui.feature.random

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.ui.common.state.UIState

class RandomQuoteViewModel :
    ViewModel() {

    private val _uiState: MutableStateFlow<UIState<Quote>> = MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<Quote>> = _uiState

    fun getRandomQuote() {
        viewModelScope.launch {
            _uiState.value = UIState.Loading

            _uiState.value = UIState.SuccessWithData(
                Quote(
                    1,
                    "Everything comes to him who hustles while he waits.",
                    "Thomas Edison"
                )
            )
        }
    }
}
