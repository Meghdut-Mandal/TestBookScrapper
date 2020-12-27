package api.question

data class Question(
    var _id: String?,
    var bn: QuestionValue?,
    var en: QuestionValue?,
    var gu: QuestionValue?,
    var hn: QuestionValue?,
    var isFixedComp: Boolean?,
    var isNum: Boolean?,
    var isPartialMarking: Boolean?,
    var kn: QuestionValue?,
    var lang: String?,
    var ml: QuestionValue?,
    var mr: QuestionValue?,
    var negMarks: Double?,
    var or: QuestionValue?,
    var partialMarks: PartialMarks?,
    var posMarks: Double?,
    var singlePageComp: Boolean?,
    var ta: QuestionValue?,
    var te: QuestionValue?,
    var type: String?
)