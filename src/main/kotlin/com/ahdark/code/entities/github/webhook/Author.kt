package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.Serializable

@Serializable
data class Author(
    val name: String,
    val email: String,
    val username: String
)
