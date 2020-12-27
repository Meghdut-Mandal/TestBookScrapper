package api.question

data class Section(
    var instructions: List<String>?,
    var isQualifyingSection: Boolean?,
    var qCount: Int?,
    var questions: List<Question>?,
    var time: Int?,
    var title: String?
)