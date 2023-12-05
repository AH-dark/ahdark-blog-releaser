package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Organization(
    val login: String,
    val id: Long,

    @SerialName("node_id")
    val nodeID: String,

    val url: String,

    @SerialName("repos_url")
    val reposURL: String,

    @SerialName("events_url")
    val eventsURL: String,

    @SerialName("hooks_url")
    val hooksURL: String,

    @SerialName("issues_url")
    val issuesURL: String,

    @SerialName("members_url")
    val membersURL: String,

    @SerialName("public_members_url")
    val publicMembersURL: String,

    @SerialName("avatar_url")
    val avatarURL: String,

    val description: String
)