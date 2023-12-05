package com.ahdark.code.services

interface SignatureService {
    fun verifySignature(signature: String, payload: ByteArray): Boolean
}