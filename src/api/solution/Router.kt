package api.solution

import api.Utils.gson
import com.google.gson.JsonElement
import com.google.gson.JsonObject
import com.google.gson.JsonSyntaxException
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import okhttp3.internal.closeQuietly


private val submission = """
    {
        "task": "submit",
        "responses": {
            "5ee20dd82a38030d0a0fff0d": {
                "markedOption": "2",
                "isBookmarked": false,
                "time": 36,
                "visits": [
                    {
                        "time": 7,
                        "attempts": 1,
                        "nextqid": "5ee20dd82a38030d0a0fff0d",
                        "logs": [
                            {
                                "t": "mo",
                                "at": 1,
                                "v": "2"
                            },
                            {
                                "t": "b",
                                "at": 4,
                                "v": "bfsn"
                            }
                        ]
                    },
                    {
                        "time": 29,
                        "attempts": 0,
                        "nextqid": "5ee20dd82a38030d0a0fff0d",
                        "logs": []
                    }
                ],
                "lang": "en"
            }
        },
        "currentQuestion": "s~1~q~15"
    }
""".trimIndent()


private fun submitTest(client: OkHttpClient, authcode: String, testID: String) {
    val mediaType = "application/json;charset=UTF-8".toMediaTypeOrNull()
    val body: RequestBody = submission.toRequestBody(mediaType)
    val request = Request.Builder()
        .url("https://api.testbook.com/api/v2/tests/$testID?auth_code=$authcode&X-Tb-Client=web,1.2&language=English")
        .method("POST", body)
        .addHeader("authority", "api.testbook.com")
        .addHeader("pragma", "no-cache")
        .addHeader("cache-control", "no-cache")
        .addHeader("accept", "application/json, text/plain, */*")
        .addHeader("dnt", "1")
        .addHeader(
            "user-agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"
        )
        .addHeader("content-type", "application/json;charset=UTF-8")
        .addHeader("origin", "https://testbook.com")
        .addHeader("sec-fetch-site", "same-site")
        .addHeader("sec-fetch-mode", "cors")
        .addHeader("sec-fetch-dest", "empty")
        .addHeader("referer", "https://testbook.com/")
        .addHeader("accept-language", "en,bn;q=0.9,en-US;q=0.8,ar;q=0.7")
        .addHeader("Cookie", "__cfduid=d19f6be0ce14a028feeb8dd14572407a11607530550")
        .build()
    val response = client.newCall(request).execute()
    response.closeQuietly()
}

fun getTestSolutions(client: OkHttpClient, authcode: String, testID: String): TestSolution? {
    submitTest(client, authcode, testID)
    val request = Request.Builder()
        .url("https://api.testbook.com/api/v2/tests/$testID/answers?auth_code=$authcode&X-Tb-Client=web,1.2&language=English")
        .method("GET", null)
        .addHeader("authority", "api.testbook.com")
        .addHeader("pragma", "no-cache")
        .addHeader("cache-control", "no-cache")
        .addHeader("accept", "application/json, text/plain, */*")
        .addHeader(
            "user-agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"
        )
        .addHeader("dnt", "1")
        .addHeader("origin", "https://testbook.com")
        .addHeader("sec-fetch-site", "same-site")
        .addHeader("sec-fetch-mode", "cors")
        .addHeader("sec-fetch-dest", "empty")
        .addHeader("referer", "https://testbook.com/")
        .addHeader("accept-language", "en,bn;q=0.9,en-US;q=0.8,ar;q=0.7")
        .addHeader("Cookie", "__cfduid=d19f6be0ce14a028feeb8dd14572407a11607530550")
        .build()
    val response = client.newCall(request).execute()
    val bodyString = response.body?.string()
    response.closeQuietly()
    val payLoad = gson.fromJson(bodyString, JsonObject::class.java)
    val success = payLoad["success"].asBoolean
    if (success){
        val dataSegemnt = payLoad["data"]?.asJsonObject ?: return null
        val solutions = dataSegemnt.entrySet().map {
            val sol = gson.toJson(it.value)
            val questionSolution = getQuestionSolution(sol, it)!!
            questionSolution
        }.toList()
        if (solutions.isEmpty())
            return  null
        return TestSolution(testID,solutions)
    }else{
        println("api.solution>>getTestSolutions Unsuccessful ;( ${payLoad["message"]}  ")
        return null
    }
}

private fun getQuestionSolution(
    sol: String?,
    it: MutableMap.MutableEntry<String, JsonElement>
): QuestionSolution? {
    try {
        return  gson.fromJson(sol, QuestionSolution::class.java).apply {
             _id = it.key
         }
    } catch (e: JsonSyntaxException) {
        e.printStackTrace()
    }
    return null
}
