package api.serriesDetails

data class Data(
    val details: TestSeriesDetails = TestSeriesDetails(),
    val studentStats: StudentStats = StudentStats()
)