package framework.utils

import framework.enums.TypeOfCell
import java.sql.DriverManager
import java.sql.ResultSet
import java.sql.SQLException
import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.set

val logger: Logger = Logger()

fun select(url: String?, login: String?, password: String?, query: String?): List<HashMap<String, String?>>? {
    logger.info("Make query $query to data base $url")
    val result: MutableList<HashMap<String, String?>> = ArrayList()
    try {
        DriverManager.getConnection(url, login, password).createStatement().executeQuery(query).let { resultSet ->
            val resultSetMetaData = resultSet.metaData
            while (resultSet.next()) {
                val row = HashMap<String, String?>()
                var i = 0
                while (i + 1 <= resultSetMetaData.columnCount) {
                    row[resultSetMetaData.getColumnLabel(i + 1)] =
                        getValueOfCell(resultSetMetaData.getColumnTypeName(i + 1), resultSet, i + 1)
                    i++
                }
                result.add(row)
            }
        }
    } catch (e: SQLException) {
        logger.warn("Exception during method select: $e")
    }
    return result
}

private fun getValueOfCell(type: String, resultSet: ResultSet, index: Int): String? {
    logger.info("Get value of cell $type")
    var result: String? = null
    when (type) {
        TypeOfCell.INT.typeCell -> result = resultSet.getInt(index).toString()
        TypeOfCell.NUMERIC.typeCell -> result = resultSet.getInt(index).toString()
        TypeOfCell.NCHAR.typeCell -> result = resultSet.getString(index)
    }
    return result
}