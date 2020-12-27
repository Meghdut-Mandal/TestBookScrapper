package api.allSeries

data class Data(
    var extraDetails: ExtraDetails?,
    var filters: Filters?,
    var results: Results?,
    var searchId: String?,
    var searchVersion: String?,
    var totalCount: TotalCount?
)