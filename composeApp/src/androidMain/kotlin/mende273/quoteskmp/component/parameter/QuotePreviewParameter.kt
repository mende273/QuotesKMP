package mende273.quoteskmp.component.parameter

import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import mende273.quoteskmp.domain.model.Quote

class QuotePreviewParameter : PreviewParameterProvider<Quote> {
    override val values: Sequence<Quote> = sequenceOf(
        Quote(
            1,
            "Everything comes to him who hustles while he waits.",
            "Thomas Edison"
        )
    )
}
