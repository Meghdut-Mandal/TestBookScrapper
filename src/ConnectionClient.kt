import api.Config
import api.Utils.gson
import okhttp3.OkHttpClient
import java.io.File

object ConnectionClient {
    val configFile = File("config.json")
    val authcode: String
    val client = OkHttpClient().newBuilder()
        .build()
    val mongoDBUrl: String
    val dataBaseName:String

    init {
        if (!configFile.exists()) {
            println(">ConnectionClient>  config.json not found in Path !! Aborting ")
            System.exit(1)
        }

        val config = gson.fromJson(File("config.json").bufferedReader(), Config::class.java)
        authcode = config.authcode
        mongoDBUrl = config.mongo_url
        dataBaseName=config.rootCollection

    }


}