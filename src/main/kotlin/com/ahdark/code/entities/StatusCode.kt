package com.ahdark.code.entities

import com.ahdark.code.serializer.StatusCodeSerializer
import kotlinx.serialization.Serializable

@Serializable(with = StatusCodeSerializer::class)
enum class StatusCode(private val code: Int) {
    SUCCESS(200),
    NOT_FOUND(404),
    UNAUTHORIZED(401),
    FORBIDDEN(403),
    BAD_REQUEST(400),
    INTERNAL_SERVER_ERROR(500),
    SERVICE_UNAVAILABLE(503),
    UNKNOWN(500);

    companion object {
        fun fromCode(code: Int): StatusCode {
            return when (code) {
                200 -> SUCCESS
                400 -> BAD_REQUEST
                401 -> UNAUTHORIZED
                403 -> FORBIDDEN
                404 -> NOT_FOUND
                500 -> INTERNAL_SERVER_ERROR
                503 -> SERVICE_UNAVAILABLE
                else -> UNKNOWN
            }
        }
    }

    fun toCode(): Int {
        return code
    }
}