package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class License(
    val key: String,
    val name: String,

    @SerialName("spdx_id")
    val spdxID: String,

    val url: String,

    @SerialName("node_id")
    val nodeID: String
)
