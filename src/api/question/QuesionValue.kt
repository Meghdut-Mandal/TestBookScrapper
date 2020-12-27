package api.question

data class QuesionValue(
    val Range: Range = Range(),
    val options: List<Option> = listOf(),
    val value: String = ""
)