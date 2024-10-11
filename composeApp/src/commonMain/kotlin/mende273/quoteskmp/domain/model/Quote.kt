package mende273.quoteskmp.domain.model

import kotlinx.serialization.Serializable

@Serializable
data class Quote(val id: Long, val content: String, val author: String)
