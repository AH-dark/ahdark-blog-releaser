package com.ahdark.code.services.impl

import com.ahdark.code.services.TelegramNotificationService
import com.ahdark.code.utils.ConfigUtils
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode

/**
 * Telegram notification service implementation
 *
 * @exception NumberFormatException: if failed to parse chat_id
 */
class TelegramNotificationServiceImpl : TelegramNotificationService {
    private val configUtils = ConfigUtils()

    private var chatId: Long = configUtils.getProperty("telegram.chat_id").toLong()
    private var botInstance: Bot = bot {
        token = configUtils.getProperty("telegram.bot.token")
    }

    /**
     * Send message to Telegram
     *
     * @param message: the message to send
     * @throws Exception: if failed to send message
     */
    override fun sendMessage(message: String) {
        botInstance.sendMessage(
            chatId = ChatId.fromId(chatId),
            text = message,
            parseMode = ParseMode.HTML
        )
    }
}
