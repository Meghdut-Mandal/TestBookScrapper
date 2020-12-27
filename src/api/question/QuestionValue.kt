package api.question

data class QuestionValue(
    var Range: Range?,
    var value:String?,
    var options : List<Options>?
)