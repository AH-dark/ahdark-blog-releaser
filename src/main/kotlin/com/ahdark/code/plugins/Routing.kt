package com.ahdark.code.plugins

import com.ahdark.code.controllers.HealthController
import com.ahdark.code.dto.BaseResponse
import io.ktor.server.application.*
import io.ktor.server.plugins.autohead.*
import io.ktor.server.resources.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    install(Resources)
    install(AutoHeadResponse)

    routing {
        get<HealthController> {
            call.respond(BaseResponse.success())
        }
    }
}

