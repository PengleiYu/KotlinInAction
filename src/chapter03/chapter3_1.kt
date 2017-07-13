package chapter03

/**
 * 在Kotlin中创建集合
 * Created by yupenglei on 17/7/13.
 */

fun test3_1_1() {
    val set = setOf(1, 4, 4)
    val list = listOf(3, 4, 5)
    val map = mapOf(1 to "One", 7 to "Seven")
    println(set.javaClass)
    println(list.javaClass)
    println(map.javaClass)

    println(list.last())
    println(list.first())
    println(list.max())
}

fun main(args: Array<String>) {
    test3_1_1()
}
