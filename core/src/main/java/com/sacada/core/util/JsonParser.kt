package com.sacada.core.util

import ViewScreen
import kotlinx.serialization.SerializationException
import kotlinx.serialization.json.Json

object JsonParser {
    fun parseScreen(json: String): ViewScreen? {
        return try {
            Json.decodeFromString(ViewScreen.serializer(), json)
        } catch (e: SerializationException) {
            println("Erro ao desserializar o JSON: ${e.message}")
            null
        }
    }
}
