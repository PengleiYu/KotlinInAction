package chapter03

/**
 * 使用集合vararg,infix,库支持
 * Created by yupenglei on 17/7/13.
 */

/**
 * 可变参数，Varargs
 * *叫做展开操作符
 */
fun main(args: Array<String>) {
//    val list = listOf("args:", *args)

    val (num, name) = 2 too "two"
    println("$num -> $name")
}

/**
 * 元组
 * 中缀调用和析构声明
 */
infix fun Any.too(other: Any) = Pair(this, other)

