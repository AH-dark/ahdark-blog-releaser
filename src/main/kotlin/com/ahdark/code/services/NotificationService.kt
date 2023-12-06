package com.ahdark.code.services

import org.koin.core.component.KoinComponent

interface NotificationService : KoinComponent {
    fun sendMessage(message: String)
}
