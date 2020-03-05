package framework.utils

import java.util.*

fun randomInRange(bound: Int): Int {
    return Random().nextInt(bound)
}