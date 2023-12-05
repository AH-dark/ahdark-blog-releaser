package com.ahdark.code.controllers

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/health")
class HealthController
