package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class HookConfig(
    @SerialName("content_type")
    val contentType: String,

    @SerialName("insecure_ssl")
    val insecureSsl: Int,
    
    val secret: String,
    val url: String
)
