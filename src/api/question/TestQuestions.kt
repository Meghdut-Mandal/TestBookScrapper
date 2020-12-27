package api.question

data class TestQuestions(
    var ContainMAMCQ: Boolean?,
    var _id: String?,
    var analysisAfter: Int?,
    var categoriseBy: String?,
    var course: String?,
    var courseid: String?,
    var derivedGroupTargets: List<DerivedGroupTarget>?,
    var duration: Int?,
    var editorNote: String?,
    var examCutOffs: ExamCutOffs?,
    var isLive: Boolean?,
    var isScholarship: Boolean?,
    var isSectionalSubmit: Boolean?,
    var lang: String?,
    var sectionTimeSharedFlag: Boolean?,
    var sections: List<Section>?,
    var servesOn: String?,
    var showCalculator: Boolean?,
    var specificExams: List<SpecificExam>?,
    var target: List<Target>?,
    var targetSuperGroup: List<TargetSuperGroup>?,
    var testInterface: String?,
    var tipsTricksPresent: Boolean?,
    var title: String?
)