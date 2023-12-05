package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hook(
    val active: Boolean,
    @SerialName("app_id")
    val appId: Int,
    val config: HookConfig,
    @SerialName("created_at")
    val createdAt: String,
    @SerialName("deliveries_url")
    val deliveriesUrl: String,
    val events: List<String>,
    val id: Int,
    @SerialName("last_response")
    val lastResponse: LastResponse,
    val name: String,
    @SerialName("ping_url")
    val pingUrl: String,
    @SerialName("test_url")
    val testUrl: String,
    val type: String,
    @SerialName("updated_at")
    val updatedAt: String,
    val url: String
)
