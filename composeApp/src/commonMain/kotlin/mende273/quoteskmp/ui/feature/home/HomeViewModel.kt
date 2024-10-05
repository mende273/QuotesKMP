package mende273.quoteskmp.ui.feature.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import mende273.quoteskmp.data.mapper.toUiState
import mende273.quoteskmp.domain.model.Quote
import mende273.quoteskmp.domain.repository.remote.RemoteRepository
import mende273.quoteskmp.ui.common.state.UIState

class HomeViewModel(private val remoteRepository: RemoteRepository) :
    ViewModel() {
    private val _uiState: MutableStateFlow<UIState<List<Quote>>> = MutableStateFlow(UIState.Loading)
    val uiState: StateFlow<UIState<List<Quote>>> = _uiState

    init {
        viewModelScope.launch { getQuotes() }
    }

    private suspend fun getQuotes() {
        _uiState.value = remoteRepository.getQuotes().fold(
            onSuccess = { it },
            onFailure = { null }
        ).toUiState()
    }
}
