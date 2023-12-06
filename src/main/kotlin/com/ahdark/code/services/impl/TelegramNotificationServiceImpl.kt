package com.ahdark.code.services.impl

import com.ahdark.code.services.TelegramNotificationService
import com.ahdark.code.utils.ConfigUtils
import com.github.kotlintelegrambot.Bot
import com.github.kotlintelegrambot.bot
import com.github.kotlintelegrambot.entities.ChatId
import com.github.kotlintelegrambot.entities.ParseMode
import org.koin.core.component.inject

/**
 * Telegram notification service implementation
 *
 * @exception NumberFormatException: if failed to parse chat_id
 */
class TelegramNotificationServiceImpl : TelegramNotificationService {
    private val configUtils: ConfigUtils by inject()

    private var chatId: Long =
        configUtils.getProperty("telegram.chat_id")?.toLong() ?: throw Exception("No telegram chat id provided")
    private var botInstance: Bot = bot {
        token = configUtils.getProperty("telegram.bot.token") ?: throw Exception("No telegram bot token provided")
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
