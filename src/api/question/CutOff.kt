package api.question

data class CutOff(
    val category: String = "",
    val lowerBound: Int = 0,
    val upperBound: Int = 0
)