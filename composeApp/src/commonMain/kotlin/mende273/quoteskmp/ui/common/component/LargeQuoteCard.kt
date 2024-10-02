package mende273.quoteskmp.ui.common.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import mende273.quoteskmp.theme.PrimaryBackgroundColor
import mende273.quoteskmp.theme.TertiaryColor
import mende273.quoteskmp.theme.largeTextStyle
import mende273.quoteskmp.theme.mediumTextStyle
import mende273.quoteskmp.theme.spacing

@Composable
fun LargeQuoteCard(content: String, author: String) {
    Card(
        modifier = Modifier
            .fillMaxSize()
            .background(color = PrimaryBackgroundColor),
        shape = MaterialTheme.shapes.medium,
        colors = CardDefaults.cardColors(
            containerColor = TertiaryColor
        )
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(MaterialTheme.spacing.normal)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                modifier = Modifier
                    .wrapContentHeight(),
                text = content,
                style = largeTextStyle()
            )
            Text(
                modifier = Modifier
                    .wrapContentHeight(),
                text = author,
                style = mediumTextStyle()
            )
        }
    }
}
