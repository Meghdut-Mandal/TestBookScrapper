package api.allTests

data class FetchAllTestResponse(
    val curTime: String = "",
    val `data`: Data = Data(),
    val success: Boolean = false
)