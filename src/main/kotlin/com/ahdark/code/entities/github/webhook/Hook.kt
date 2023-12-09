package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Hook(
    val type: String,
    val id: Long,
    val name: String,
    val active: Boolean,
    val events: List<String>,
    val config: HookConfig,

    @SerialName("app_id")
    val appID: Long? = null,

    @SerialName("updated_at")
    val updatedAt: String,

    @SerialName("created_at")
    val createdAt: String,

    val url: String,

    @SerialName("test_url")
    val testURL: String,

    @SerialName("ping_url")
    val pingURL: String,

    @SerialName("deliveries_url")
    val deliveriesURL: String,

    @SerialName("last_response")
    val lastResponse: LastResponse
)
