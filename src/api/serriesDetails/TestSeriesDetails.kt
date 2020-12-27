package api.serriesDetails

data class TestSeriesDetails(
    val canPurchaseThrough: String = "",
    val colourHex: String = "",
    val course: Course = Course(),
    val description: String = "",
    val exam: Exam = Exam(),
    val faqDetails: List<FaqDetail> = listOf(),
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
    val target: List<Target> = listOf(),
    val targetGroup: Any? = null,
    val targetSuperGroup: Any? = null,
    val totalAttempts: Int = 0
)