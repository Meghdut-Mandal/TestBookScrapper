package api.serriesDetails

data class Section(
    val id: String = "",
    val name: String = "",
    val shortName: String = "",
    val subsections: List<Subsection> = listOf()
)