package api.question

data class Question(
    val _id: String = "",
    val bn: QuesionValue?,
    val en: QuesionValue? ,
    val gu: QuesionValue? ,
    val hn: QuesionValue?,
    val isFixedComp: Boolean = false,
    val isNum: Boolean = false,
    val isPartialMarking: Boolean = false,
    val kn:QuesionValue?,
    val lang: String = "",
    val ml:QuesionValue?,
    val mr: QuesionValue?,
    val negMarks: Double = 0.0,
    val or: QuesionValue?,
    val partialMarks: PartialMarks = PartialMarks(),
    val posMarks: Int = 0,
    val singlePageComp: Boolean = false,
    val ta:QuesionValue?,
    val te:QuesionValue?,
    val type: String = ""
)