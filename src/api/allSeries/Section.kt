package api.allSeries

data class Section(
    var freeTestCount: Int?,
    var id: String?,
    var name: String?,
    var order: Int?,
    var paidTestCount: Int?,
    var shortName: String?,
    var subsections: List<Subsection>?
)