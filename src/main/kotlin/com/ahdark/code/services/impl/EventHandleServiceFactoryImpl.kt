package com.ahdark.code.services.impl

import com.ahdark.code.entities.github.webhook.EventType
import com.ahdark.code.services.EventHandleService
import com.ahdark.code.services.EventHandleServiceFactory

class EventHandleServiceFactoryImpl : EventHandleServiceFactory {
    override fun createService(eventType: EventType): EventHandleService {
        return when (eventType) {
            EventType.PING -> PingEventHandleService()
            EventType.PUSH -> PushEventHandleService()
        }
    }
}
