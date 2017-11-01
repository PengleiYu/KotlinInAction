package chapter02

import java.io.BufferedReader
import java.io.StringReader

/**
 * Kotlin异常
 * Created by yupenglei on 17/7/13.
 */

/**
 * try,catch,finally
 * Kotlin异常处理类似Java
 * 不要求抛出异常
 */
fun readNumber(reader: BufferedReader): Int? {
    try {
        val line = reader.readLine()
        return Integer.parseInt(line)
    } catch (e: NumberFormatException) {
        return null
    } finally {
        reader.close()
    }
}

/**
 * try作为表达式
 * 目前有三个表达式了：if、when、try
 */
fun readNumber2(reader: BufferedReader) {
    val number = try {
        Integer.parseInt(reader.readLine())
    } catch (e: NumberFormatException) {
//        return
        null
    }
    println(number)
}

fun test2_5_1() {
    val reader = BufferedReader(StringReader("1234a"))
    val readNumber = readNumber2(reader)
//    println(readNumber)
}

fun main(args: Array<String>) {
    test2_5_1()
}
