package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import mende273.quoteskmp.theme.spacing

@Composable
fun FullSizeBox(
    contentAlignment: Alignment = Alignment.Center,
    background: Color = MaterialTheme.colorScheme.background,
    outerPaddingValues: PaddingValues = PaddingValues(),
    innerPaddingValues: PaddingValues = PaddingValues(MaterialTheme.spacing.normal),
    contents: @Composable () -> Unit
) {
    Box(
        modifier = Modifier
            .background(background)
            .padding(outerPaddingValues)
            .fillMaxSize()
            .padding(innerPaddingValues),
        contentAlignment = contentAlignment
    ) {
        contents()
    }
}
