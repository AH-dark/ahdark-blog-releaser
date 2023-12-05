package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Commit(
    val id: String,

    @SerialName("tree_id")
    val treeID: String,

    val distinct: Boolean,
    val message: String,
    val timestamp: String,
    val url: String,
    val author: Author,
    val committer: Author,
    val added: List<String>,
    val removed: List<String>,
    val modified: List<String>
)
