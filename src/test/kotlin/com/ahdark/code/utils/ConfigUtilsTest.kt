package com.ahdark.code.utils

import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.inject
import kotlin.test.AfterTest
import kotlin.test.BeforeTest
import kotlin.test.Test

class ConfigUtilsTest : KoinTest {
    @BeforeTest
    fun before() {
        startKoin {
            modules(utilsModule)
        }
    }

    @AfterTest
    fun tearDown() {
        stopKoin()
    }

    private val configUtils by inject<ConfigUtils>()

    @Test
    fun getProperty() {
        val property = configUtils.getProperty("telegram.chat_id")
        println(property)
    }
}