package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import mende273.quoteskmp.ui.theme.mediumTextStyle

@Composable
fun ErrorText(reason: String) {
    Text(
        modifier = Modifier.wrapContentSize(),
        text = reason,
        style = mediumTextStyle(),
        textAlign = TextAlign.Center
    )
}
