package framework.utils

import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.nio.charset.Charset

fun getResponseInString(httpConn: HttpURLConnection?): String? {
    logger.info("Get response in string")
    var outputString = ""
    try {
        BufferedReader(InputStreamReader(httpConn!!.inputStream, Charset.forName("UTF-8"))).let { reader ->
            reader.lines().forEach {
                outputString += it
            }
        }
    } catch (e: Exception) {
        logger.warn("Exception: ${e.message}")
    }
    return outputString
}