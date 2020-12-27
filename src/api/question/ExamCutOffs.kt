package api.question

data class ExamCutOffs(
    var isAdminNotified: Boolean?,
    var isSectionalCutOffsAbsent: Boolean?,
    var overAll: OverAll?
)