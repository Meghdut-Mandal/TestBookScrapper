package api.serriesDetails

data class Section(
    var id: String?,
    var name: String?,
    var shortName: String?,
    var subsections: List<Subsection>?
)