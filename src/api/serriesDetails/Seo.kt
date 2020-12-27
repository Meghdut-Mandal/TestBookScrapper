package api.serriesDetails

data class Seo(
    val metaDescription: String = "",
    val metaTitle: String = "",
    val ogProperties: OgProperties = OgProperties()
)