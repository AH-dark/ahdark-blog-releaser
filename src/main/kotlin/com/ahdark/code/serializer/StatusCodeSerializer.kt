package com.ahdark.code.serializer

import com.ahdark.code.entities.StatusCode
import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder

object StatusCodeSerializer : KSerializer<StatusCode> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("StatusCode", PrimitiveKind.INT)

    override fun serialize(encoder: Encoder, value: StatusCode) {
        encoder.encodeInt(value.toCode())
    }

    override fun deserialize(decoder: Decoder): StatusCode {
        return StatusCode.fromCode(decoder.decodeInt())
    }
}
