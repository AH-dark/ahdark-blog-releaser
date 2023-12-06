package com.ahdark.code.utils

import java.io.InputStream
import java.util.*

class ConfigUtils {
    private val props = Properties()
    private val inputStream: InputStream? =
        Thread.currentThread().contextClassLoader.getResourceAsStream("config.properties")

    init {
        inputStream.use { props.load(it) }
    }

    fun getProperty(key: String): String {
        return props.getProperty(key)
    }
}