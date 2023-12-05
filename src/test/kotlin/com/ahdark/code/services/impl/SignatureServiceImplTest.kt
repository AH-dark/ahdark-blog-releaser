package com.ahdark.code.services.impl

import com.ahdark.code.services.SignatureService
import kotlin.test.Test


class SignatureServiceImplTest {
    val signatureService: SignatureService = SignatureServiceImpl("It's a Secret to Everybody")

    @Test
    fun verifySignature() {
        val payload = "Hello, World!"
        signatureService.verifySignature(
            "757107ea0eb2509fc211221cce984b8a37570b6d7586c22c46f4379c8b043e17",
            payload.toByteArray()
        )
    }
}