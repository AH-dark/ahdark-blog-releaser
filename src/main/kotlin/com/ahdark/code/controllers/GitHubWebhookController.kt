package com.ahdark.code.controllers

import io.ktor.resources.*
import kotlinx.serialization.Serializable

@Serializable
@Resource("/api/v1/github/webhook")
class GitHubWebhookController
