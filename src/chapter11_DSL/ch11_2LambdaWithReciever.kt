package chapter11_DSL

/**
 * 带接收者的lambda
 * Created by yupenglei on 17/11/1.
 */

/**
 * 使用时，函数体中每次都要调用it
 */
private fun buildString1(builderAction: (StringBuilder) -> Unit): String {
    val sb = StringBuilder()
    builderAction(sb)
    return sb.toString()
}

/**
 * 以带接收者的lambda为参数
 * 使用时，函数体将不用指定调用者了
 *
 * 扩展函数类型
 * [StringBuilder].([Int],[Int])->[Unit]
 * 接收者类型.(参数类型)->返回类型
 */
private fun buildString2(builderAction: StringBuilder.() -> Unit): String {
    val sb = StringBuilder()
//    builderAction(sb) //这种方式亦可
    sb.builderAction()
    return sb.toString()
}

/**
 * 变量保存带接收者的lambda
 */
val appendExcel: StringBuilder.() -> Unit = { append("!") }

/**
 * 标准库中的带接收者的lambda
 * [kotlin.with], let, apply, also, run, takeIf, takeUnless, [kotlin.repeat], [kotlin.require]
 * [buildString], append
 */

fun main(args: Array<String>) {
//    val a = buildString1 {
//        it.append("Hello, ")
//        it.append("World!")
//    }
//    println(a)
//    val b = buildString2 {
//        append("Hello, ")
//        append("world!")
//    }
//    println(b)
//    val sb = StringBuilder("Hello")
//    sb.also(appendExcel)
//    sb.apply(appendExcel)
//    println(sb)
    { println("Hello") }()
}