package framework.utils

import org.w3c.dom.Document
import org.xml.sax.InputSource
import java.io.StringReader
import java.util.*
import javax.xml.parsers.DocumentBuilderFactory

fun parseXmlFile(input: String?): Document? {
    return try {
        DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(InputSource(StringReader(input)))
    } catch (e: Exception) {
        throw RuntimeException(e)
    }
}

fun getTagValue(document: Document?, tagName: String?): String? = document?.getElementsByTagName(tagName)?.item(0)?.textContent

fun getListTagNames(document: Document?, HeadTag: String?): List<String>? {
    val allNodes = document!!.getElementsByTagName(HeadTag).item(0).childNodes
    val result: MutableList<String> = ArrayList()
    for (i in 0 until allNodes.length) {
        result.add(allNodes.item(i).nodeName)
    }
    return result
}