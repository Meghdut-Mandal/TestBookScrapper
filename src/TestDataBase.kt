import api.allSeries.TestSeries
import api.allSeries.getTestSeries
import api.allTests.Test
import api.allTests.getAllTests
import api.question.TestQuestions
import api.question.getQuestion
import api.serriesDetails.TestSeriesDetails
import api.serriesDetails.getTestDetails
import api.solution.TestSolution
import api.solution.getTestSolutions
import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.module.kotlin.KotlinModule
import org.litote.kmongo.* //NEEDED! import KMongo extensions
import java.util.concurrent.Executor
import java.util.concurrent.Executors
import java.util.concurrent.ForkJoinPool
import java.util.concurrent.TimeUnit
import java.util.Spliterator
import java.util.Spliterators
import java.util.stream.Stream
import java.util.stream.StreamSupport
import com.mongodb.client.model.UpdateOptions


object TestDataBase {
    val client =
        KMongo.createClient(ConnectionClient.mongoDBUrl) //get com.mongodb.MongoClient new instance
    val database = client.getDatabase(ConnectionClient.dataBaseName)
    val testSeriesDetailsCol = database.getCollection<TestSeriesDetails>() //KMongo extension method
    val testSerriesCol = database.getCollection<TestSeries>()
    val testsCol = database.getCollection<Test>()
    val testQuestionCol = database.getCollection<TestQuestions>()
    val testSolCol = database.getCollection<TestSolution>()
    var options = UpdateOptions().upsert(true)


    fun complete() {
        database.drop()
        loadAllSerries()
        loadSeriesDetails()
        loadAllTests()
        loadQuestions()
        loadSolutions()
    }


    @JvmStatic
    fun main(args: Array<String>) {
        complete()
    }

    private fun loadSolutions() {
        testSolCol.drop()
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        testQuestionCol.find().forEach {
            val solution = getTestSolutions(client, code, it._id!!)
            if (solution != null) {
                testSolCol.updateOne(solution, options)
                println(">TestDataBase>loadSolutions  ${solution._id} ")
            } else {
                println(">TestDataBase>loadSolutions  Null At ${it._id} ")
            }
        }
    }

    private fun loadQuestions() {
        testQuestionCol.drop()
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        testsCol.find().toList().parallelStream().forEach {
            val question = getQuestion(client, code, it.id!!)
            println(">TestDataBase>loadQuestions  ${question?._id} ")
            if (question?._id != null) {
                testQuestionCol.updateOne(question, options)
            }
        }
    }

    private fun loadAllTests() {
        testsCol.drop()
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        testSerriesCol.find().toList().parallelStream().forEach {
            var skip = 0
            do {
                val allTests = getAllTests(client, code, it.id!!, skip)
                println(">TestDataBase>loadAllTests  $allTests ")
                if (allTests.isNotEmpty()) {
                    testsCol.insertMany(allTests)
                }
                skip += allTests.size
            } while (allTests.isNotEmpty())
        }
    }


    private fun loadSeriesDetails() {
        testSeriesDetailsCol.drop()
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        testSerriesCol.find().toList().parallelStream().forEach {
            val id: String = it.id ?: "nil"
            if (id == "nil") {
                println(">TestDataBase>loadSeriesDetails  Nil id ")
            } else {
                val deatils = getTestDetails(client, code, id) ?: return@forEach
                testSeriesDetailsCol.insertOne(deatils)
                println(">TestDataBase>loadSeriesDetails  ${deatils} ")
            }

        }
    }

    private fun loadAllSerries(skip: Int = 0) {
        println(">TestDataBase>loadAllSerries  skipping $skip ")
        val client = ConnectionClient.client
        val code = ConnectionClient.authcode
        val testSeries = getTestSeries(client, code, skip).distinctBy { it.id }
        if (testSeries.isNotEmpty()) {
            testSerriesCol.insertMany(testSeries)
            loadAllSerries(skip + testSeries.size)
        }
    }

}

