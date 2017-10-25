package chapter08_HigherOrderFunction

import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.InputStreamReader

/**
 * 内联函数,相当于函数体被复制到调用处
 * Created by yupenglei on 17/10/13.
 */
/**
 * inline应该只用于接收lambda的函数
 * lambda若被保存为变量则失去内联能力
 */
inline fun printInt(value: Int, callback: (Int) -> Unit) {
    println("Hello before")
    callback(value)
    println("Hello after")
}

fun testInline() {
    printInt(22) {
        println(it)
    }
}

fun testInline2(callback: (Int) -> Unit) {
    printInt(33, callback)
}

/**
 * use函数用于closable，会自动关闭资源
 */
fun testUseResource(): String {
    val file = File("README.md")
    BufferedReader(InputStreamReader(FileInputStream(file))).use {
        return it.readLine()
    }
}

fun main(args: Array<String>) {
    testUseResource().let { println(it) }
}