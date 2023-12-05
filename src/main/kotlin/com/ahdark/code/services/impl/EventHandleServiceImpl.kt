package com.ahdark.code.services.impl

import com.ahdark.code.entities.github.webhook.events.PingEvent
import com.ahdark.code.entities.github.webhook.events.PushEvent
import com.ahdark.code.services.EventHandleService

class EventHandleServiceImpl : EventHandleService {
    override fun handlePingEvent(event: PingEvent) {
        println("PingEvent: $event")
    }

    override fun handlePushEvent(event: PushEvent) {
        println("PushEvent: $event")
    }
}