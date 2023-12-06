package com.ahdark.code.services

import org.koin.core.component.KoinComponent

interface EventHandleService : KoinComponent {
    fun handleEvent(payload: ByteArray)
}
