package com.ahdark.code

import com.ahdark.code.plugins.configureRouting
import io.ktor.server.testing.*
import kotlin.test.Test

class ApplicationTest {
    @Test
    fun testRoot() = testApplication {
        application {
            configureRouting()
        }
    }
}
