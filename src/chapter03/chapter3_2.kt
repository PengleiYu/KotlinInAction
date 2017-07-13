package chapter03

/**
 * 让函数便于调用
 * 1，添加默认值
 * 2，使用Jvm重载注解，生成带各种数目参数的函数
 * Created by yupenglei on 17/7/13.
 */

@JvmOverloads //由于Java中没有默认参数，所以使用该注解可以自动生成参数个数不同的方法
fun <T> joinToString_Java(
        collection: Collection<T>, separator: String = ",",
        prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)
    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

/**
 * 顶层属性
 * 可通过getter和setter访问
 */
var opCount = 0

/**
 * 顶层函数
 */
fun performOperation() = opCount++

fun reportOperationCount() = println("Operation performed $opCount times")

fun main(args: Array<String>) {
    val list = listOf(1, 2, 3, 4, 5)
    println(list)
    println(joinToString_Java(collection = list, separator = "-", prefix = "<", postfix = ">"))
}
