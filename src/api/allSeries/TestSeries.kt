package api.allSeries

data class TestSeries(
    val analysis: Analysis = Analysis(),
    val canPurchaseThrough: String = "",
    val colourHex: String = "",
    val course: Course = Course(),
    val description: String = "",
    val exam: Exam = Exam(),
    val faqs: Any? = null,
    val features: List<Feature> = listOf(),
    val freeTestCount: Int = 0,
    val icon: String = "",
    val id: String = "",
    val isFree: Boolean = false,
    val languages: Any? = null,
    val name: String = "",
    val paidTestCount: Int = 0,
    val sections: List<Section> = listOf(),
    val seo: Seo = Seo(),
    val showSyllabus: Boolean = false,
    val slug: String = "",
    val studentStats: StudentStats = StudentStats(),
    val target: List<Target> = listOf(),
    val targetGroup: List<TargetGroup> = listOf(),
    val targetSuperGroup: Any? = null,
    val totalAttempts: Int = 0
)