package com.ahdark.code.dto

import kotlinx.serialization.Serializable

@Serializable
data class BaseResponse<T>(
    val code: Int = 0,
    val msg: String = "success",
    val data: T? = null
) {
    companion object {
        fun <T> success(data: T? = null) = BaseResponse(data = data)
        fun success() = BaseResponse<Unit>()
        fun error(code: Int = -1, msg: String = "error") = BaseResponse<Unit>(code = code, msg = msg)
    }
}

