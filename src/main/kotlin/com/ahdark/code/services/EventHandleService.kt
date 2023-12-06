package com.ahdark.code.services

interface EventHandleService {
    fun handleEvent(payload: ByteArray)
}
