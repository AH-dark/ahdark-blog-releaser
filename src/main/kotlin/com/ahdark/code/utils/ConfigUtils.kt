package com.ahdark.code.utils

import java.io.File
import java.io.InputStream
import java.util.*

class ConfigUtils {
    private val configFileName = "config.properties"

    private val props = Properties()
    private val resourceStream: InputStream? = javaClass.classLoader.getResourceAsStream(configFileName)

    init {
        resourceStream?.use { props.load(it) }

        initFromLocal()
    }

    private fun initFromLocal() {
        val configFile = File(configFileName)
        if (configFile.exists()) {
            configFile.inputStream().use { props.load(it) }
        }
    }

    fun getProperty(key: String): String? {
        return props.getProperty(key)
    }
}
