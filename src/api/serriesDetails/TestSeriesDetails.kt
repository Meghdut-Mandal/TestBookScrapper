package api.serriesDetails

data class TestSeriesDetails(
    var canPurchaseThrough: String?,
    var colourHex: String?,
    var course: Course?,
    var description: String?,
    var exam: Exam?,
    var faqDetails: List<FaqDetail>?,
    var features: List<Feature>?,
    var freeTestCount: Int?,
    var icon: String?,
    var id: String?,
    var isFree: Boolean?,
    var languages: Any?,
    var name: String?,
    var paidTestCount: Int?,
    var sections: List<Section>?,
    var seo: Seo?,
    var showSyllabus: Boolean?,
    var slug: String?,
    var target: List<Target>?,
    var targetGroup: Any?,
    var targetSuperGroup: Any?,
    var totalAttempts: Int?
)