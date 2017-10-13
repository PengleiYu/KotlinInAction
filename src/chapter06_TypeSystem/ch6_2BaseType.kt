package chapter06_TypeSystem

import java.util.*

/**
 * Created by yupenglei on 17/10/11.
 */
/**
 * 将Int强制区间
 */
fun showProgress(progress: Int) {
    val percent = progress.coerceIn(0, 100)
    println("We`re $percent% done!")
}

/**
 * 数字和字符串的进制转换
 */
fun stringAndInt() {
    val aInt = 11
    val aString = "11"
    listOf(2, 8, 16)
            .onEach { println(aString.toInt(it)) }
            .onEach { println(aInt.toString(it)) }
}

/**
 * 赋值
 */
fun test() {
    val i: Int = 0b11
    val l: Long = 22
    val f: Float = 2f
    val d: Double = 22.0
    val i2: Int = 'c'.toInt()
    i + l
}

/**
 * 创建字母表
 */
fun createAlphaBeta() {
    val letters = Array(26) { ('a' + it).toString() }
    Arrays.toString(letters).let { println(it) }
    val range = 'a'..'z'
    val letter2 = range.map { it.toString() }.toList().toTypedArray()
    Arrays.toString(letter2).let { println(it) }
//            .map { it.toString() }.toList()
}

fun main(args: Array<String>) {
    createAlphaBeta()
}