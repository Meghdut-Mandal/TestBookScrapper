package api.allSeries

data class Subsection(
    val freeTestCount: Int = 0,
    val id: String = "",
    val name: String = "",
    val order: Int = 0,
    val paidTestCount: Int = 0,
    val tests: Any? = null
)