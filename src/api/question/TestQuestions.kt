package api.question

data class TestQuestions(
    val ContainMAMCQ: Boolean = false,
    val _id: String = "",
    val analysisAfter: Int = 0,
    val categoriseBy: String = "",
    val course: String = "",
    val courseid: String = "",
    val derivedGroupTargets: List<DerivedGroupTarget> = listOf(),
    val duration: Int = 0,
    val editorNote: String = "",
    val examCutOffs: ExamCutOffs = ExamCutOffs(),
    val isLive: Boolean = false,
    val isScholarship: Boolean = false,
    val isSectionalSubmit: Boolean = false,
    val lang: String = "",
    val sectionTimeSharedFlag: Boolean = false,
    val sections: List<Section> = listOf(),
    val servesOn: String = "",
    val showCalculator: Boolean = false,
    val specificExams: List<SpecificExam> = listOf(),
    val target: List<Target> = listOf(),
    val targetSuperGroup: List<TargetSuperGroup> = listOf(),
    val testInterface: String = "",
    val tipsTricksPresent: Boolean = false,
    val title: String = ""
)