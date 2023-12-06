package com.ahdark.code.services.impl

import com.ahdark.code.services.SignatureService
import com.ahdark.code.services.servicesModule
import com.ahdark.code.utils.utilsModule
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test


class SignatureServiceImplTest : KoinTest {
    @BeforeTest
    fun before() {
        startKoin {
            modules(utilsModule)
            modules(servicesModule)
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    private val signatureService by inject<SignatureService>()

    @Test
    fun verifySignature() {
        val payload = "Hello, World!"
        signatureService.verifySignature(
            "757107ea0eb2509fc211221cce984b8a37570b6d7586c22c46f4379c8b043e17",
            payload.toByteArray()
        )
    }
}