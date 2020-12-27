package api.allSeries

data class Seo(
    val metaDescription: String = "",
    val metaKeywords: String = "",
    val metaTitle: String = "",
    val ogProperties: OgProperties = OgProperties()
)