package api.allSeries

data class Data(
    var extraDetails: ExtraDetails?,
    var filters: Any?,
    var results: Results?,
    var searchId: String?,
    var searchVersion: String?,
    var totalCount: TotalCount?
)