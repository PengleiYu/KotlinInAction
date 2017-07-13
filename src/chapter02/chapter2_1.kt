package chapter02

/**
 * 基本元素：函数和变量
 * Created by yupenglei on 17/7/13.
 */
fun main(args: Array<String>) {
    println("Hello, World!")
    println(max(2, 5))
    println(min(2, 5))

}

//function
fun max(a: Int, b: Int): Int {
    return if (a > b) a else b//主体
}

fun min(a: Int, b: Int) = if (a < b) a else b//表达式主体，可自动推断返回值


// variable
val question = "The Ultimate question of Life, the Universe, and Everything"//val对应Java中的final
val answer = 42//省略类型声明
val answer2: Int = 42//Java式声明
val yearsToCompute = 7.5e6

fun test() {
    val answer3: Int
    answer3 = 42

    val message: String
    if (2 > 34) {
        message = "hah"
    } else {
        message = "heh"
    }
}
