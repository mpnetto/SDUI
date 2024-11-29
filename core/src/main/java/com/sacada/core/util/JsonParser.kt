package com.sacada.core.util

import ViewScreen
import kotlinx.serialization.json.Json

object JsonParser {
    fun parseScreen(json: String): ViewScreen {
        return Json.decodeFromString(json)
    }
}