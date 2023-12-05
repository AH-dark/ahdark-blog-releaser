package com.ahdark.code.entities.github.webhook.events

import com.ahdark.code.entities.github.webhook.Hook
import com.ahdark.code.entities.github.webhook.Organization
import com.ahdark.code.entities.github.webhook.Repository
import com.ahdark.code.entities.github.webhook.Sender
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PingEvent(
    val hook: Hook,
    @SerialName("hook_id")
    val hookId: Long,
    val organization: Organization,
    val repository: Repository,
    val sender: Sender,
    val zen: String
)
