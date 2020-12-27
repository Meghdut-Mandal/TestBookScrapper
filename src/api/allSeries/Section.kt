package api.allSeries

data class Section(
    val freeTestCount: Int = 0,
    val id: String = "",
    val name: String = "",
    val order: Int = 0,
    val paidTestCount: Int = 0,
    val shortName: String = "",
    val subsections: List<Subsection> = listOf()
)