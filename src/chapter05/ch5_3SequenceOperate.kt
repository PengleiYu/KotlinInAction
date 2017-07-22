package chapter05

import java.io.File

/**
 * 惰性的集合操作：序列操作
 * Created by JJBOOM on 2017/7/23.
 */
private data class Man(val name: String, val age: Int)

/**
 * asSequence序列操作，惰性，延迟计算
 * Kotlin的序列类似Java8的stream，但并未实现多CPU并行执行的能力
 */
private fun test1() {
    val man = listOf(Man("Tom", 22), Man("Lily", 23), Man("Kat", 22))
    val list = man.asSequence()
            .map(Man::name)
            .filter { it.startsWith("T") }
            .toList()
    println(list)
}

/**
 * 创建序列
 */
private fun test2() {
    val naturalNumbers = generateSequence(0) { it + 1 }
    val numbersTo100 = naturalNumbers.takeWhile { it <= 100 }
    println(numbersTo100.sum())//此时执行所有的延迟操作
}

/**
 * 序列的另一种使用场景
 * 父级
 */
private fun test3() {
    fun File.isInsideHiddenDirectory() =
            generateSequence(this) { it.parentFile }.any { it.isHidden }

    val file = File(".")
    println(file.isInsideHiddenDirectory())

}

/**
 * 后面的文档断了
 * todo
 */

fun main(args: Array<String>) {
    test3()
}