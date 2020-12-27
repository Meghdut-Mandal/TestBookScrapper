package api.question

data class OverAll(
    val SNo: Int = 0,
    val cutOffs: List<CutOff> = listOf(),
    val title: String = ""
)