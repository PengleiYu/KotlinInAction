package chapter05

/**
 * 集合的函数式api
 * Created by JJBOOM on 2017/7/23.
 */
/**
 * filter,map略
 */

/**
 * map的操作
 */
private fun test1() {
    val numbers = mapOf(0 to "zero", 1 to "one")
    println(numbers.mapValues { it.value.toUpperCase() })
    println(numbers.mapKeys { it.key * 2 })
    println(numbers.filterKeys { it == 1 })
    println(numbers.filterValues { it.length > 3 })
}

/**
 * all,any,count,find
 * 引入predicate
 */
private fun test2() {
    val list = listOf(23, 2, 4, 1, 44, 21, 53)
    println(list.all { it % 2 == 1 })//全部匹配
    println(list.any { it % 2 == 0 })//任何匹配
    println(list.find { it < 9 })//find只返回符合的第一个
    println(list.filter { it < 9 })//filter返回符合的所有
    println(list.filter { it % 2 == 0 }.size)//临时创建集合后返回size
    println(list.filter { it % 2 == 0 }.count())//未创建集合，比size更高效
}

/**
 * groupBy
 */

/**
 * flatMap,flatten
 */
private fun test3() {
    val list = listOf(1..5, 3..7, 6..9)
    println(list)
    println(list.flatten())//扁平化
}

fun main(args: Array<String>) {
    test3()
}