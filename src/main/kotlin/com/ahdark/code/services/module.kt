package com.ahdark.code.services

import com.ahdark.code.services.impl.*
import org.koin.dsl.module

var servicesModule = module {
    single<TelegramNotificationService> { TelegramNotificationServiceImpl() }
    single<SignatureService> { SignatureServiceImpl() }

    single<EventHandleFactoryService> { EventHandleFactoryServiceImpl() }
    factory { PingEventHandleService() }
    factory { PushEventHandleService() }
}
