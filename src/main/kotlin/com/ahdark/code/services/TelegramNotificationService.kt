package com.ahdark.code.services

interface TelegramNotificationService : NotificationService {
    /**
     * Send message to telegram
     *
     * @param message message to send
     * @throws Exception if failed to send message
     */
    override fun sendMessage(message: String)
}
