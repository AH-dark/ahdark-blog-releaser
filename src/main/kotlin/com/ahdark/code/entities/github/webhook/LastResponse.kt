package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.Serializable

@Serializable
data class LastResponse(
    val code: Int?,
    val message: String?,
    val status: String?
)
