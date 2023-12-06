package com.ahdark.code.utils

import org.koin.dsl.module

var utilsModule = module {
    single<ConfigUtils> { ConfigUtils() }
}
