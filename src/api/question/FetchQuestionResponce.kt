package api.question

data class FetchQuestionResponce(
    val curTime: String = "",
    val `data`: TestQuestions = TestQuestions(),
    val success: Boolean = false
)