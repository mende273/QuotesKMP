package mende273.quoteskmp.ui.common.component

import androidx.compose.runtime.Composable
import mende273.quoteskmp.ui.common.state.UIState
import org.jetbrains.compose.resources.stringResource
import quoteskmp.composeapp.generated.resources.Res
import quoteskmp.composeapp.generated.resources.error
import quoteskmp.composeapp.generated.resources.no_data


@Composable
fun <T> UiStateWrapper(
    uiState: UIState<T>,
    onErrorRetrievingData: @Composable () -> Unit = {
        FullSizeBox { ErrorText(reason = stringResource(Res.string.error)) }
    },
    onLoading: @Composable () -> Unit = {
        FullSizeBox { ProgressBar() }
    },
    onSuccessWithData: @Composable (T) -> Unit,
    onSuccessWithoutData: @Composable () -> Unit = {
        FullSizeBox { ErrorText(reason = stringResource(Res.string.no_data)) }
    }
) {
    when (uiState) {
        UIState.Loading -> onLoading()
        UIState.ErrorRetrievingData -> onErrorRetrievingData()
        UIState.SuccessWithNoData -> onSuccessWithoutData()
        is UIState.SuccessWithData -> onSuccessWithData(uiState.data)
    }
}
