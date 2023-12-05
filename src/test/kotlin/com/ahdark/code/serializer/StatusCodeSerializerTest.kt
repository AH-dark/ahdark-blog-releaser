package com.ahdark.code.serializer

import com.ahdark.code.entities.StatusCode
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.test.Test
import kotlin.test.assertEquals

class StatusCodeSerializerTest {
    @Test
    fun serialize() {
        val statusCode = StatusCode.SUCCESS
        val json = Json {
            serializersModule = SerializersModule {
                contextual(StatusCode::class, StatusCodeSerializer)
            }
        }
        val serialized = json.encodeToString(StatusCodeSerializer, statusCode)
        assertEquals("200", serialized)
    }

    @Test
    fun deserialize() {
        val json = Json {
            serializersModule = SerializersModule {
                contextual(StatusCode::class, StatusCodeSerializer)
            }
        }
        val deserialized = json.decodeFromString(StatusCodeSerializer, "200")
        assertEquals(StatusCode.SUCCESS, deserialized)
    }
}