package com.ahdark.code.entities.github.webhook.events

import com.ahdark.code.entities.github.webhook.Hook
import com.ahdark.code.entities.github.webhook.Repository
import com.ahdark.code.entities.github.webhook.Sender
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PingEvent(
    val zen: String,

    @SerialName("hook_id")
    val hookID: Long,

    val hook: Hook,
    val repository: Repository,
    val sender: Sender
)
