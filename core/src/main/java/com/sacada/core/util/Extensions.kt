package com.sacada.core.util

import ViewComponent
import kotlinx.serialization.json.JsonPrimitive
import kotlinx.serialization.json.contentOrNull

fun ViewComponent.getStringAttribute(key: String): String {
    return attributes[key]?.let {
        if (it is JsonPrimitive) it.contentOrNull
        else it.toString()
    }?: ""
}
