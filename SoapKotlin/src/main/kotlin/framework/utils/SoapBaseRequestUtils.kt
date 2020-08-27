package framework.utils

import java.io.ByteArrayOutputStream
import java.net.HttpURLConnection
import java.net.URL

private const val CONTENT_TYPE = "text/xml; charset=utf-8"
private const val POST_REQUEST = "POST"
private const val IS_DO_OUTPUT = true
private const val IS_DO_INPUT = true

fun sendSoapRequest(urlToSend: String?, action: String?, request: String): HttpURLConnection? {
    logger.info("Send request $action to $urlToSend")
    var httpConn: HttpURLConnection? = null
    try {
        httpConn = URL(urlToSend).openConnection() as HttpURLConnection
        val outputStream = ByteArrayOutputStream()
        outputStream.write(request.toByteArray())
        val bytes = outputStream.toByteArray()
        setConnectionProperty(httpConn, bytes.size.toString(), action)
        httpConn.outputStream.also {
            it.write(bytes)
            it.close()
        }
    } catch (e: Exception) {
        logger.warn("Exception: $e")
    }
    return httpConn
}

fun setConnectionProperty(httpURLConnection: HttpURLConnection, contentLength: String, soapAction: String?) =
    with(httpURLConnection) {
        logger.info("Set connection properties")
        setRequestProperty("Content-Length", contentLength)
        setRequestProperty("Content-Type", CONTENT_TYPE)
        setRequestProperty("SOAPAction", soapAction)
        requestMethod = POST_REQUEST
        doOutput = IS_DO_OUTPUT
        doInput = IS_DO_INPUT
    }