package com.ahdark.code.services.impl

import com.ahdark.code.entities.github.webhook.events.PushEvent
import com.ahdark.code.services.EventHandleService
import com.ahdark.code.services.TelegramNotificationService
import kotlinx.serialization.json.Json
import org.intellij.lang.annotations.Language
import org.koin.core.component.inject
import kotlin.math.min

/**
 * Handle the push event
 *
 * @property telegramNotificationService: the Telegram notification service
 */
class PushEventHandleService : EventHandleService {
    private val telegramNotificationService: TelegramNotificationService by inject()

    /**
     * Handle the push event
     *
     * @param payload: the payload of the event
     */
    override fun handleEvent(payload: ByteArray) {
        val event = Json.decodeFromString(PushEvent.serializer(), payload.decodeToString())

        if (event.commits.isEmpty()) return
        if (event.ref != "refs/heads/main") return

        sendTelegramMessage(event) // Send a message to Telegram
    }

    private fun sendTelegramMessage(event: PushEvent) {
        @Language("HTML") val message = """
        <b>Update occurred on ${event.repository.fullName}</b>
        
        ${event.pusher.name} pushed ${event.commits.size} commits to ${event.ref}.
        
        ${
            event.commits
                .subList(0, min(10, event.commits.size))
                .sortedBy { it.timestamp }
                .joinToString("\n        ") {
                    "<b>${it.id.substring(0, 7)}</b> ${it.message.split("\n").first()} by ${it.author.name}"
                }
        }
        
        Website will be updated soon, via <a href="https://preview.ahdark.blog">https://preview.ahdark.blog</a> to see the latest changes.
        """.trimIndent()

        telegramNotificationService.sendMessage(message)
    }
}
