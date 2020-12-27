package api.question

import api.Utils
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.closeQuietly

fun getQuestion(client: OkHttpClient,authcode:String,testid:String): TestQuestions? {
    val request: Request = Request.Builder()
        .url("https://api.testbook.com/api/v2/tests/$testid?auth_code=$authcode&X-Tb-Client=web,1.2&language=English")
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
    val fetchQuestionResponce= Utils.gson.fromJson(bodyString,FetchQuestionResponce::class.java) ?: return null
    return fetchQuestionResponce.data
}