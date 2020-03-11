package framework.utils

import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.ObjectInputStream
import java.io.ObjectOutputStream

fun serializationObject(any: Any?, path: String?) {
    logger.info("Serialization object to $path")
    try {
        ObjectOutputStream(FileOutputStream(path)).also {
            it.writeObject(any)
            it.close()
        }
    } catch (e: Exception) {
        logger.warn("Exception: ${e.message}")
    }
}

fun deserializationObject(path: String?): Any? {
    logger.info("deserialization object from $path")
    var newObject: Any? = null
    try {
        ObjectInputStream(FileInputStream(path)).also {
            newObject = it.readObject()
            it.close()
        }

    } catch (e: Exception) {
        logger.warn("Exception: ${e.message}")
    }
    return newObject
}