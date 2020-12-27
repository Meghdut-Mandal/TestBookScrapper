package api.allSeries

data class FetchSerriesResponce(
    val curTime: String = "",
    val `data`: Data = Data(),
    val success: Boolean = false
)