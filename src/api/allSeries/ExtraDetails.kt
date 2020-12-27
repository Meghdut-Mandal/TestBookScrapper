package api.allSeries

data class ExtraDetails(
    val registeredData: RegisteredData = RegisteredData(),
    val resumableTests: Any? = null,
    val submissions: Any? = null
)