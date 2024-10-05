package mende273.quoteskmp.ui.feature.today

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.remote.RemoteRepository
import mende273.quoteskmp.ui.common.state.UIState

class QuoteOfTheDayViewModel(
    private val remoteRepository: RemoteRepository
) : ViewModel() {

    private val _uiState: MutableStateFlow<UIState<Quote>> = MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<Quote>> = _uiState

    fun getQuoteOfTheDay() {
        viewModelScope.launch {
            _uiState.value = UIState.Loading

            _uiState.value = remoteRepository.getQuoteOfTheDay().fold(
                onSuccess = {
                    UIState.SuccessWithData(it)
                },
                onFailure = {
                    UIState.ErrorRetrievingData
                }
            )
        }
    }
}
