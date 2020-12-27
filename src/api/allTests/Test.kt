package api.allTests

data class Test(
    var availFrom: String?,
    var availTill: String?,
    var course: Course?,
    var cutOffs: CutOffs?,
    var description: String?,
    var duration: Int?,
    var endTime: String?,
    var id: String?,
    var isFree: Boolean?,
    var isLive: Boolean?,
    var languages: List<String>?,
    var questionCount: Int?,
    var specificExams: List<SpecificExam>?,
    var startTime: String?,
    var target: List<Target>?,
    var targetSuperGroup: List<TargetSuperGroup>?,
    var title: String?,
    var totalAttempts: Int?,
    var totalMark: Int?
)