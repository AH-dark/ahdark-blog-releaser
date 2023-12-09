package com.ahdark.code.serializer

import kotlinx.serialization.ExperimentalSerializationApi
import kotlinx.serialization.KSerializer
import kotlinx.serialization.SerializationException
import kotlinx.serialization.Serializer
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import kotlinx.serialization.json.JsonDecoder
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.long
import kotlinx.serialization.json.longOrNull
import java.text.SimpleDateFormat
import java.util.*

@OptIn(ExperimentalSerializationApi::class)
@Serializer(forClass = Long::class)
object TimestampSerializer : KSerializer<Long> {
    private val dateFormat = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.US).apply {
        timeZone = TimeZone.getTimeZone("UTC")
    }

    override fun serialize(encoder: Encoder, value: Long) {
        encoder.encodeLong(value)
    }

    override fun deserialize(decoder: Decoder): Long {
        if (decoder !is JsonDecoder) {
            throw SerializationException("This serializer can only be used with JSON")
        }

        val element = decoder.decodeJsonElement()
        return when {
            element is JsonPrimitive && element.longOrNull != null -> element.long
            element is JsonPrimitive -> parseDate(element.content)
            else -> throw SerializationException("Invalid JSON element found for TimestampSerializer")
        }
    }

    /**
     * Parses a date string in the format "yyyy-MM-dd'T'HH:mm:ss'Z'".
     *
     * @throws SerializationException if the date string is not in the correct format.
     */
    private fun parseDate(dateString: String): Long {
        return try {
            dateFormat.parse(dateString)?.time ?: throw SerializationException("Invalid date format")
        } catch (e: Exception) {
            throw SerializationException("Error parsing date string: $dateString", e)
        }
    }
}
