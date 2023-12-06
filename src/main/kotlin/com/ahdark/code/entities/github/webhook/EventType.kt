package com.ahdark.code.entities.github.webhook

import kotlinx.serialization.Serializable

@Serializable
enum class EventType(val value: String) {
    PING("ping"),
    PUSH("push");

    companion object {
        fun fromString(value: String): EventType = when (value) {
            "ping" -> PING
            "push" -> PUSH
            else -> throw IllegalArgumentException()
        }
    }

    override fun toString(): String = when (this) {
        PING -> "ping"
        PUSH -> "push"
    }
}
