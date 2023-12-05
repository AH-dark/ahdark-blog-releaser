package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.Serializable


@Serializable
data class Pusher(
    val name: String,
    val email: String? = null
)
