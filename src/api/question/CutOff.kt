package api.question

data class CutOff(
    var category: String?,
    var lowerBound: Int?,
    var upperBound: Int?
)