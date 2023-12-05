package com.ahdark.code.entities.github.webhook.events

import com.ahdark.code.entities.github.webhook.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class PushEvent(
    val ref: String,
    val before: String,
    val after: String,
    val repository: Repository,
    val pusher: Pusher,
    val sender: Sender,
    val created: Boolean,
    val deleted: Boolean,
    val forced: Boolean,

    @SerialName("base_ref")
    val baseRef: String? = null,

    val compare: String,
    val commits: List<Commit>,

    @SerialName("head_commit")
    val headCommit: Commit,

    val organization: Organization? = null
)






