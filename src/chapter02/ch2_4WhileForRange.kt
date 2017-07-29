package chapter02

import java.util.*

/** 遍历：while和for循环
 * Created by yupenglei on 17/7/13.
 */

//while和Java一样


/**
 * 遍历数字：范围和数列
 * in
 */
val oneToTen = 1..10//ranges
val rang1 = 1 until 10//不包含结尾
val rang2 = 100..1 step 2//带步长
val rang3 = 100 downTo 1 step 2//降序带步长
val rang4 = 1 downTo 100//将为空


fun fizzBuzz(i: Int) = when {
    i % 15 == 0 -> "FizzBuzz "
    i % 3 == 0 -> "Fizz "
    i % 5 == 0 -> "Buzz "
    else -> "$i "
}


/**
 * 遍历映射集
 */
fun test2_4_2() {
    val binaryReps = TreeMap<Char, String>()
    for (c in 'A'..'F') {//ranges可以用在字符上
        val binary = Integer.toBinaryString(c.toInt())
        binaryReps[c] = binary
    }
    for ((letter, binary) in binaryReps) {//遍历集合
        println("$letter = $binary")
    }
}

/**
 * 带位置的遍历
 */
fun test2_4_3() {
    val list = arrayListOf("10", "11", "1001")
    for ((index, element) in list.withIndex()) {//withIndex
        println("$index: $element")
    }
}

/**
 * 使用in检查
 */
fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'

fun isNotDigit(c: Char) = c !in '0'..'9'

/**
 * in也可以用在when中
 */
fun recognize(c: Char) = when (c) {
    in '0'..'9' -> "It is a digit"
    in 'a'..'z', in 'A'..'Z' -> "It is a letter"
    else -> "I don`t know..."
}

/**
 * 凡是实现了Comparable接口的都可以作为范围对象
 */
fun test2_4_4() = println("Kotlin" in "Java".."Scala")//此时，检查的是字符串排序，介于二者之间

fun test2_4_42() = println("Kotlin" in "Scala".."Java")//false

fun test2_4_43() = println("Kotlin" in setOf("Java", "Scala"))//false,不在集合中

fun main(args: Array<String>) {
//    for (i in 1..100) {
//        print(fizzBuzz(i))
//    }
//    for (i in 100 downTo 1 step 2) {//步进值数列
//        print(fizzBuzz(i))
//    }
//    test2_4_2()
//    test2_4_3()
//    println(isLetter('q'))
//    println(isNotDigit('x'))
//    println(recognize('9'))
    test2_4_4()
    test2_4_42()
    test2_4_43()
}

