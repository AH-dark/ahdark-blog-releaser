package com.ahdark.code.services

import org.koin.core.component.KoinComponent

interface SignatureService : KoinComponent {
    /**
     * Verify the signature of the payload
     *
     * @param signature The signature of the payload
     * @param payload The payload of the event
     * @return true if the signature is valid, false otherwise
     */
    fun verifySignature(signature: String, payload: ByteArray): Boolean
}
