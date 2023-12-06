package com.ahdark.code.services

import com.ahdark.code.entities.github.webhook.EventType
import org.koin.core.component.KoinComponent

interface EventHandleFactoryService : KoinComponent {
    fun handleEvent(event: EventType, payload: ByteArray)
}
