package api.allSeries

import api.Utils
import com.google.gson.Gson
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.internal.closeQuietly

fun getTestSeries(client: OkHttpClient, skip: Int, limit: Int,authCode:String): List<TestSeries> {

    val request: Request = Request.Builder()
        .url(
            "https://api.testbook.com/api/v1/search/individual?auth_code=$authCode&X-Tb-Client=web,1.2&language=English&term=test&searchObj=testSeries&searchId=&__projection=%7B%22count%22%3A%7B%22articles%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22courses%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22examPages%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22quizzes%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22tests%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22videos%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%2C%22testSeries%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%7D%2C%22extraDetails%22%3A%7B%22submissions%22%3A%7B%22id%22%3A1%2C%22isAttempted%22%3A1%2C%22correct%22%3A1%2C%22attemptedOn%22%3A1%2C%22markScored%22%3A1%2C%22rank%22%3A1%2C%22totalStudents%22%3A1%7D%2C%22registeredData%22%3A%7B%22registeredTests%22%3A1%2C%22registeredQuizzes%22%3A1%7D%2C%22resumableTests%22%3A1%7D%2C%22filterDetails%22%3A%7B%22filterName%22%3A1%2C%22filterTitle%22%3A1%2C%22filterQueryKey%22%3A1%7D%2C%22filters%22%3A1%2C%22order%22%3A1%2C%22results%22%3A%7B%22articles%22%3A%22%22%2C%22courses%22%3A1%2C%22examPages%22%3A%7B%22_id%22%3A1%2C%22heading%22%3A1%2C%22icon%22%3A1%2C%22slug%22%3A1%7D%2C%22quizzes%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%2C%22description%22%3A1%2C%22isFree%22%3A1%2C%22isLive%22%3A1%2C%22availFrom%22%3A1%2C%22startTime%22%3A1%2C%22endTime%22%3A1%2C%22availTill%22%3A1%2C%22duration%22%3A1%2C%22questionCount%22%3A1%2C%22totalMark%22%3A1%2C%22totalAttempts%22%3A1%2C%22cutOffs%22%3A%7B%22overAll%22%3A%7B%22cutOffs%22%3A%7B%22category%22%3A1%2C%22lowerBound%22%3A1%2C%22upperBound%22%3A1%7D%7D%7D%2C%22course%22%3A%7B%22id%22%3A1%7D%2C%22testSeriesIds%22%3A1%2C%22specificExams%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%7D%7D%2C%22tests%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%2C%22description%22%3A1%2C%22isFree%22%3A1%2C%22isLive%22%3A1%2C%22availFrom%22%3A1%2C%22startTime%22%3A1%2C%22endTime%22%3A1%2C%22availTill%22%3A1%2C%22duration%22%3A1%2C%22questionCount%22%3A1%2C%22totalMark%22%3A1%2C%22totalAttempts%22%3A1%2C%22cutOffs%22%3A%7B%22overAll%22%3A%7B%22cutOffs%22%3A%7B%22category%22%3A1%2C%22lowerBound%22%3A1%2C%22upperBound%22%3A1%7D%7D%7D%2C%22course%22%3A%7B%22id%22%3A1%7D%2C%22testSeriesIds%22%3A1%2C%22specificExams%22%3A%7B%22id%22%3A1%2C%22title%22%3A1%7D%7D%2C%22videos%22%3Anull%2C%22testSeries%22%3A%7B%22id%22%3A1%2C%22slug%22%3A1%2C%22name%22%3A1%2C%22icon%22%3A1%2C%22colorHex%22%3A1%2C%22paidTestCount%22%3A1%2C%22freeTestCount%22%3A1%2C%22totalAttempts%22%3A1%2C%22sections%22%3A%7B%22id%22%3A1%2C%22name%22%3A1%2C%22shortName%22%3A1%2C%22subsections%22%3A%7B%22id%22%3A1%2C%22name%22%3A1%2C%22paidTestCount%22%3A1%2C%22freeTestCount%22%3A1%7D%7D%2C%22studentStats%22%3A1%7D%7D%2C%22searchId%22%3A1%2C%22totalCount%22%3A%7B%22value%22%3A1%2C%22relation%22%3A1%7D%7D" +
                    "&skip=$skip&limit=$limit&filter=%5B%5D"
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
    val fetchSerriesResponce=Utils.gson.fromJson(bodyString,FetchSerriesResponce::class.java)?: return emptyList()
    return fetchSerriesResponce.data.results.testSeries

}