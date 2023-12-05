package com.ahdark.code.entities

import kotlin.test.Test
import kotlin.test.assertEquals

class StatusCodeTest {
    @Test
    fun toCode() {
        assertEquals(200, StatusCode.SUCCESS.toCode())
        assertEquals(400, StatusCode.BAD_REQUEST.toCode())
        assertEquals(401, StatusCode.UNAUTHORIZED.toCode())
        assertEquals(403, StatusCode.FORBIDDEN.toCode())
        assertEquals(404, StatusCode.NOT_FOUND.toCode())
        assertEquals(500, StatusCode.INTERNAL_SERVER_ERROR.toCode())
        assertEquals(503, StatusCode.SERVICE_UNAVAILABLE.toCode())
        assertEquals(500, StatusCode.UNKNOWN.toCode())  // 确认 UNKNOWN 的预期行为
    }

    @Test
    fun fromCode() {
        assertEquals(StatusCode.SUCCESS, StatusCode.fromCode(200))
        assertEquals(StatusCode.BAD_REQUEST, StatusCode.fromCode(400))
        assertEquals(StatusCode.UNAUTHORIZED, StatusCode.fromCode(401))
        assertEquals(StatusCode.FORBIDDEN, StatusCode.fromCode(403))
        assertEquals(StatusCode.NOT_FOUND, StatusCode.fromCode(404))
        assertEquals(StatusCode.INTERNAL_SERVER_ERROR, StatusCode.fromCode(500))
        assertEquals(StatusCode.SERVICE_UNAVAILABLE, StatusCode.fromCode(503))
        assertEquals(StatusCode.UNKNOWN, StatusCode.fromCode(999))  // 使用一个未映射的值测试 UNKNOWN
    }
}
