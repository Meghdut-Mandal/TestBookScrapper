package api.question

data class ExamCutOffs(
    val isAdminNotified: Boolean = false,
    val isSectionalCutOffsAbsent: Boolean = false,
    val overAll: OverAll = OverAll()
)