package api.serriesDetails

import api.Utils
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.closeQuietly



fun getTestDetails(
    client: OkHttpClient,
    authCode: String,
    testSerriesId: String
): TestSeriesDetails? {
    val request: Request = Request.Builder()
        .url(
            "https://api.testbook.com/api/v2/test-series/$testSerriesId?auth_code=$authCode&X-Tb-Client=web,1.2&language=English&__projection=%7B%22details%22%3A%7B%22name%22%3A1%2C%22icon%22%3A1%2C%22colourHex%22%3A1%2C%22showSyllabus%22%3A1%2C%22description%22%3A1%2C%22paidTestCount%22%3A1%2C%22freeTestCount%22%3A1%2C%22id%22%3A1%2C%22slug%22%3A1%2C%22isFree%22%3A1%2C%22course%22%3A%7B%22id%22%3A1%7D%2C%22seo%22%3A%7B%22metaTitle%22%3A1%2C%22metaDescription%22%3A1%2C%22metaKeywords%22%3A1%2C%22ogProperties%22%3A%7B%22title%22%3A1%2C%22image%22%3A1%7D%7D%2C%22exam%22%3A%7B%22id%22%3A1%7D%2C%22faqDetails%22%3A%7B%22title%22%3A1%2C%22subTitle%22%3A1%2C%22faqs%22%3A%7B%22question%22%3A1%2C%22answer%22%3A1%7D%7D%2C%22features%22%3A%7B%22title%22%3A1%2C%22subtitle%22%3A1%2C%22iconUrl%22%3A1%7D%2C%22sections%22%3A%7B%22id%22%3A1%2C%22name%22%3A1%2C%22shortName%22%3A1%2C%22subsections%22%3A%7B%22id%22%3A1%2C%22name%22%3A1%2C%22paidTestCount%22%3A1%2C%22freeTestCount%22%3A1%7D%7D%2C%22canPurchaseThrough%22%3A1%2C%22totalAttempts%22%3A1%2C%22target%22%3A1%2C%22targetGroup%22%3A1%2C%22targetSuperGroup%22%3A1%2C%22languages%22%3A1%7D%2C%22studentStats%22%3A%7B%22testsAttempted%22%3A1%2C%22accessDetails%22%3A%7B%22canAccess%22%3A1%2C%22enrolled%22%3A1%7D%7D%7D"
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

    val testSerriesDetailsResponce =
        Utils.gson.fromJson(bodyString, TestSerriesDetailsResponce::class.java) ?: return null
    return testSerriesDetailsResponce.data.details
}