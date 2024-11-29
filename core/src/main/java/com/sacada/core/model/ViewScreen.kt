import kotlinx.serialization.Serializable
import kotlinx.serialization.json.JsonElement

@Serializable
data class ViewScreen(
    val attributes: Map<String, JsonElement> = emptyMap(),
    val topBar: ViewComponent? = null,
    val bottomBar: ViewComponent? = null,
    val layout: ViewComponent? = null
)
