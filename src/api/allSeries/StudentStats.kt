package api.allSeries

data class StudentStats(
    val accessDetails: AccessDetails = AccessDetails(),
    val testsAttempted: Int = 0,
    val updatedOn: String = ""
)