package api.solution

import api.question.PartialMarks
import api.question.Range

data class QuestionSolution(
    var correctOption: String?,
    var isPartialMarking: Boolean?,
    var multiCorrectOptions: Any?,
    var negMarks: Double?,
    var partialM: PartialMarks?,
    var posMarks: Double?,
    var range: Range?,
    var sol: Sol?,
    var stats: Stats?,
    var tags: List<String>?,
    var votes: Int?,
    var _id:String?
)