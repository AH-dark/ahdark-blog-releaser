package com.ahdark.code

import com.ahdark.code.plugins.configureMonitoring
import com.ahdark.code.plugins.configureRouting
import com.ahdark.code.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module,
        configure = {
            connectionGroupSize = 1
            workerGroupSize = 2
            callGroupSize = 2
        }
    )
        .start(wait = true)
}

fun Application.module() {
    configureMonitoring()
    configureSerialization()
    configureRouting()
}
