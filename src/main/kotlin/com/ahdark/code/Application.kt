package com.ahdark.code

import com.ahdark.code.plugins.configureMonitoring
import com.ahdark.code.plugins.configureRouting
import com.ahdark.code.plugins.configureSerialization
import com.ahdark.code.services.servicesModule
import com.ahdark.code.utils.utilsModule
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*
import org.koin.core.context.startKoin
import org.koin.ktor.plugin.Koin

fun main() {
    embeddedServer(
        Netty,
        port = 8080,
        host = "0.0.0.0",
        module = Application::module
    )
        .start(wait = true)
}

fun Application.module() {
    startKoin {
        modules(utilsModule)
        modules(servicesModule)

        install(Koin) {
            modules(servicesModule)
        }
    }

    configureMonitoring()
    configureSerialization()
    configureRouting()
}
