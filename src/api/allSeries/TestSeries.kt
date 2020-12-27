package api.allSeries

data class TestSeries(
    var analysis: Analysis?,
    var canPurchaseThrough: String?,
    var colourHex: String?,
    var course: Course?,
    var description: String?,
    var exam: Exam?,
    var faqs: Any?,
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
    var studentStats: StudentStats?,
    var target: List<Target>?,
    var targetGroup: List<TargetGroup>?,
    var targetSuperGroup: Any?,
    var totalAttempts: Int?
)