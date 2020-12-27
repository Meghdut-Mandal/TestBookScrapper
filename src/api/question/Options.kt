package api.question

import com.google.gson.annotations.SerializedName

data class Options (
    @SerializedName("prompt") var prompt : Int?,
    @SerializedName("value") var value : String?
)