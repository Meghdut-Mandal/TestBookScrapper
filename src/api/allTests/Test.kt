package api.allTests

data class Test(
    val availFrom: String = "",
    val availTill: String = "",
    val course: Course = Course(),
    val cutOffs: CutOffs = CutOffs(),
    val description: String = "",
    val duration: Int = 0,
    val endTime: String = "",
    val id: String = "",
    val isFree: Boolean = false,
    val isLive: Boolean = false,
    val languages: List<String>? = null,
    val questionCount: Int = 0,
    val specificExams: List<SpecificExam> = listOf(),
    val startTime: String = "",
    val target: List<Target> = listOf(),
    val targetSuperGroup: List<TargetSuperGroup> = listOf(),
    val title: String = "",
    val totalAttempts: Int = 0,
    val totalMark: Int = 0
)