package api.allTests

import api.Utils
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.closeQuietly


fun getAllTests(client: OkHttpClient,authCode:String,testSerriesID:String): List<Test> {
    val request: Request = Request.Builder()
        .url(
            "https://api.testbook.com/api/v2/test-series/$testSerriesID/tests/details?auth_code=$authCode&X-Tb-Client=web,1.2&language=English&__projection=%7B%22tests%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%2C%22description%22%3A1%2C%22isFree%22%3A1%2C%22isLive%22%3A1%2C%22availFrom%22%3A1%2C%22endTime%22%3A1%2C%22startTime%22%3A1%2C%22availTill%22%3A1%2C%22duration%22%3A1%2C%22questionCount%22%3A1%2C%22totalMark%22%3A1%2C%22totalAttempts%22%3A1%2C%22cutOffs%22%3A%7B%22overAll%22%3A%7B%22cutOffs%22%3A%7B%22category%22%3A1%2C%22lowerBound%22%3A1%2C%22upperBound%22%3A1%7D%7D%7D%2C%22course%22%3A%7B%22id%22%3A1%7D%2C%22specificExams%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%7D%2C%22isTestDiscussionPresent%22%3A1%2C%22target%22%3A1%2C%22targetGroup%22%3A1%2C%22targetSuperGroup%22%3A1%2C%22languages%22%3A1%7D%7D&testType=all&sectionId=&subSectionId=&skip=0&limit=25"
        )
        .method("GET", null)
        .addHeader("Accept", "application/json, text/plain, */*")
        .addHeader(
            "User-Agent",
            "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/87.0.4280.88 Safari/537.36"
        )
        .addHeader("DNT", "1")
        .addHeader("Sec-Fetch-Site", "same-site")
        .addHeader("Sec-Fetch-Mode", "cors")
        .addHeader("Sec-Fetch-Dest", "empty")
        .addHeader("Cookie", "__cfduid=d19f6be0ce14a028feeb8dd14572407a11607530550")
        .build()
    val response = client.newCall(request).execute()
    val bodyString = response.body?.string()
    response.closeQuietly()
    val fetchAllTestResponse= Utils.gson.fromJson(bodyString, FetchAllTestResponse::class.java)
    return  fetchAllTestResponse.data?.tests ?: emptyList()


}