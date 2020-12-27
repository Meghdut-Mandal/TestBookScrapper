package api.allSeries

data class Data(
    val extraDetails: ExtraDetails = ExtraDetails(),
    val filters: Filters = Filters(),
    val results: Results = Results(),
    val searchId: String = "",
    val searchVersion: String = "",
    val totalCount: TotalCount = TotalCount()
)