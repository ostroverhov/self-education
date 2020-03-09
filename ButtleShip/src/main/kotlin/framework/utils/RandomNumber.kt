package framework.utils

import java.util.*

fun randomInRange(bound: Int): Int {
    logger.info("Get random number in range $bound")
    return Random().nextInt(bound)
}