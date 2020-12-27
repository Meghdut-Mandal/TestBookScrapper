package api.question

data class Section(
    val instructions: List<String> = listOf(),
    val isQualifyingSection: Boolean = false,
    val qCount: Int = 0,
    val questions: List<Question> = listOf(),
    val time: Int = 0,
    val title: String = ""
)