package mende273.quoteskmp.data.model.dto

import kotlinx.serialization.Serializable

@Serializable
data class QuoteDTO(
    val c: Long?,
    val q: String,
    val a: String
)
