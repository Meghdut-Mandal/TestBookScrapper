package api.solution

data class Attempts(
    var correct: Int?,
    var incorrect: Int?,
    var partial: Int?,
    var skipped: Int?
)