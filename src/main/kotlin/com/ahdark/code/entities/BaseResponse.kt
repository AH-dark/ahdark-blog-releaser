package com.ahdark.code.entities

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val code: StatusCode = StatusCode.SUCCESS,
    val msg: String = "success",
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T? = null) = BaseResponse(data = data)
        fun success() = BaseResponse<Unit>()
        fun error(code: StatusCode = StatusCode.UNKNOWN, msg: String = "error") =
            BaseResponse<Unit>(code = code, msg = msg)
    }
}

