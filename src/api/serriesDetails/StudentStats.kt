package api.serriesDetails

data class StudentStats(
    val accessDetails: AccessDetails = AccessDetails(),
    val testsAttempted: Int = 0
)