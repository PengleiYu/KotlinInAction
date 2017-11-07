package io

import java.io.File

/**
 * kotlin IO操作
 * Created by yupenglei on 17/11/7.
 */

private fun test1() {
    val reader = File("README.md").inputStream().bufferedReader()
    val s1 = reader.use { it.readText() }
    println(s1)
}

/**
 * 可略去inputStream
 */
private fun test2() {
    val reader = File("README.md").bufferedReader()
    val s1 = reader.use { it.readText() }
    println(s1)
}

/**
 * 再略去bufferedReader，不过只能用useLines了
 */
private fun test3() {
    val s1 = File("README.md").useLines { it.joinToString() }
    println(s1)
}

/**
 * 工具函数
 */
private fun writeSomthing(block: (File) -> Unit) {
    val file = File("kotlin.txt")
    file.delete()
    block(file)
    file.useLines { println(it.joinToString()) }
}

/**
 * use printWriter
 */
private fun test4() {
    writeSomthing { it.printWriter().use { it.println("printWriter write something") } }
}

/**
 * use bufferedWriter
 */
private fun test5() {
    writeSomthing { it.bufferedWriter().use { it.write("bufferWriter write something") } }
}

/**
 * 直接使用file
 */
private fun test6() {
    writeSomthing {
        it.writeText("something")
        it.appendText("\n")
        it.appendText("other any")
    }
}

fun main(args: Array<String>) {
    test5()
}