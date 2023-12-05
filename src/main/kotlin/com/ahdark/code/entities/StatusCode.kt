package com.ahdark.code.entities

import kotlinx.serialization.Serializable

@Serializable
enum class StatusCode {
    SUCCESS,
    ERROR,
    NOT_FOUND,
    UNAUTHORIZED,
    FORBIDDEN,
    BAD_REQUEST,
    INTERNAL_SERVER_ERROR,
    SERVICE_UNAVAILABLE,
    UNKNOWN
}