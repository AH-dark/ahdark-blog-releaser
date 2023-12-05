package com.ahdark.code.services

import com.ahdark.code.entities.github.webhook.events.PingEvent
import com.ahdark.code.entities.github.webhook.events.PushEvent

interface EventHandleService {
    fun handlePingEvent(event: PingEvent)
    fun handlePushEvent(event: PushEvent)
}