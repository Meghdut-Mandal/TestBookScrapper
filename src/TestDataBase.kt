import api.allSeries.TestSeries
import api.allSeries.getTestSeries
import api.allTests.Test
import api.question.TestQuestions
import api.serriesDetails.TestSeriesDetails
import api.serriesDetails.getTestDetails
import org.litote.kmongo.* //NEEDED! import KMongo extensions


object TestDataBase {
    val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
    val database = client.getDatabase("testBook")
    val testSeriesDetailsCol = database.getCollection<TestSeriesDetails>() //KMongo extension method
    val testSerriesCol = database.getCollection<TestSeries>()
    val testsCol = database.getCollection<Test>()
    val testQuestionCol = database.getCollection<TestQuestions>()

    @JvmStatic
    fun main(args: Array<String>) {
        loadAllSerries()
//        loadSeriesDetails()
    }


    fun loadSeriesDetails(){
        testSerriesCol.find().toList().forEach {
            val client = ConnectionClient.client
            val code = ConnectionClient.authcode
            val deatils= getTestDetails(client,code,it.id)
            println(">TestDataBase>loadSeriesDetails  ${deatils?.exam} ")
        }
    }

    fun loadAllSerries(skip: Int = 0) {
        println(">TestDataBase>loadAllSerries  skipping $skip ")
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        val testSeries = getTestSeries(client, code,skip)
        if (testSeries.isNotEmpty()) {
            testSerriesCol.insertMany(testSeries)
            loadAllSerries(skip+testSeries.size)
        }
    }

}

