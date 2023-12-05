package com.ahdark.code.services.impl

import com.ahdark.code.services.SignatureService
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

class SignatureServiceImpl(private val secretToken: String) : SignatureService {
    /**
     * Verify the signature of the payload.
     *
     * @param signature The signature string to compare.
     * @param payload The payload string to encrypt.
     */
    override fun verifySignature(signature: String, payload: ByteArray): Boolean {
        val hmac = Mac.getInstance("HmacSHA256")
        val secretKeySpec = SecretKeySpec(secretToken.toByteArray(), "HmacSHA256")
        hmac.init(secretKeySpec)

        val digest = hmac.doFinal(payload)
        val computedSignature = "sha256=" + digest.joinToString("") { "%02x".format(it) }

        return secureCompare(computedSignature, signature)
    }

    private fun secureCompare(a: String, b: String): Boolean {
        if (a.length != b.length) {
            return false
        }

        var result = 0
        for (i in a.indices) {
            result = result or (a[i].code xor b[i].code)
        }

        return result == 0
    }
}