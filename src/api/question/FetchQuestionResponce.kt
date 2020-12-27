package api.question

data class FetchQuestionResponce(
    var curTime: String?,
    var `data`: TestQuestions?,
    var success: Boolean?
)