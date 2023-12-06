package com.ahdark.code.services.impl

import com.ahdark.code.entities.github.webhook.EventType
import com.ahdark.code.services.EventHandleFactoryService
import org.koin.core.component.inject

class EventHandleFactoryServiceImpl : EventHandleFactoryService {
    private val pingEventHandleService: PingEventHandleService by inject()
    private val pushEventHandleService: PushEventHandleService by inject()

    /**
     * Handle event by event type
     *
     * @param event: the type of the event
     * @param payload: the payload of the event
     */
    override fun handleEvent(event: EventType, payload: ByteArray) {
        when (event) {
            EventType.PING -> pingEventHandleService.handleEvent(payload)
            EventType.PUSH -> pushEventHandleService.handleEvent(payload)
        }
    }
}