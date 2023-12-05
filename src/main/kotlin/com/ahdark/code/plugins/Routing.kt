package com.ahdark.code.plugins

import com.ahdark.code.controllers.GitHubWebhookController
import com.ahdark.code.controllers.HealthController
import com.ahdark.code.entities.BaseResponse
import com.ahdark.code.entities.StatusCode
import com.ahdark.code.entities.github.webhook.events.PushEvent
import com.ahdark.code.services.EventHandleService
import com.ahdark.code.services.SignatureService
import com.ahdark.code.services.impl.EventHandleServiceImpl
import com.ahdark.code.services.impl.SignatureServiceImpl
import io.ktor.server.application.*
import io.ktor.server.plugins.autohead.*
import io.ktor.server.request.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

fun Application.configureRouting() {
    install(Resources)
    install(AutoHeadResponse)

    val props = Properties()
    environment.classLoader.getResourceAsStream("config.properties")?.use {
        props.load(it)
    }

    val eventHandleService: EventHandleService = EventHandleServiceImpl()
    val signatureService: SignatureService =
        SignatureServiceImpl(props.getProperty("github.webhook.secret"))

    routing {
        get<HealthController> {
            call.respond(BaseResponse.success())
        }
        get<GitHubWebhookController> {
            val event = call.request.header("X-GitHub-Event")
            val signature = call.request.header("X-Hub-Signature-256")

            if (event == null || signature == null) {
                call.respond(
                    BaseResponse.error(
                        code = StatusCode.BAD_REQUEST,
                        msg = "Missing required headers"
                    )
                )
                return@get
            }

            if (!signatureService.verifySignature(signature, call.receiveText().toByteArray())) {
                call.respond(
                    BaseResponse.error(
                        code = StatusCode.FORBIDDEN,
                        msg = "Signature verification failed"
                    )
                )
                return@get
            }

            when (event) {
                "ping" -> {
                    try {
                        val eventData = call.receive<PushEvent>()
                        eventHandleService.handlePushEvent(eventData)
                    } catch (e: Exception) {
                        call.respond(
                            BaseResponse.error(
                                code = StatusCode.INTERNAL_SERVER_ERROR,
                                msg = e.message ?: "Unknown error"
                            )
                        )
                        return@get
                    }
                }

                "push" -> {
                    try {
                        val eventData = call.receive<PushEvent>()
                        eventHandleService.handlePushEvent(eventData)
                    } catch (e: Exception) {
                        call.respond(
                            BaseResponse.error(
                                code = StatusCode.INTERNAL_SERVER_ERROR,
                                msg = e.message ?: "Unknown error"
                            )
                        )
                        return@get
                    }
                }

                else -> {
                    call.respond(BaseResponse.error(msg = "Unsupported event"))
                    return@get
                }
            }

            call.respond(BaseResponse.success())
        }
    }
}
