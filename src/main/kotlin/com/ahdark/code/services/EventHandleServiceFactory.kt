package com.ahdark.code.services

import com.ahdark.code.entities.github.webhook.EventType

interface EventHandleServiceFactory {
    fun createService(eventType: EventType): EventHandleService
}
