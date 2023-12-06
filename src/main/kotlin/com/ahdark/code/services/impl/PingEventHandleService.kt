package com.ahdark.code.services.impl

import com.ahdark.code.entities.github.webhook.events.PingEvent
import com.ahdark.code.services.EventHandleService
import kotlinx.serialization.json.Json

/**
 * Handle the ping event
 */
class PingEventHandleService : EventHandleService {
    /**
     * Handle the ping event
     *
     * @param payload: the payload of the event
     */
    override fun handleEvent(payload: ByteArray) {
        val event = Json.decodeFromString(PingEvent.serializer(), payload.decodeToString())
        val data = Json.encodeToString(PingEvent.serializer(), event)
        println("ping event data: $data")
    }
}
