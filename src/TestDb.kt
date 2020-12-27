import org.litote.kmongo.* //NEEDED! import KMongo extensions

data class Jedi(val name: String, val age: Int)


object TestDb {
    val client = KMongo.createClient() //get com.mongodb.MongoClient new instance
    val database = client.getDatabase("test") //normal java driver usage
    val col = database.getCollection<Jedi>() //KMongo extension method
}

fun main() {

}