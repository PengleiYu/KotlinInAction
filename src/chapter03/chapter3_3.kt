package chapter03

/**
 * 把方法添加到他人的类中
 * Created by yupenglei on 17/7/13.
 */

/**
 * 扩展函数
 * 只对当前文件有效，若想在其他文件使用，需要import
 * import chapter03.lastChar as last；可起别名
 *
 * String是接收器类型
 * this是接收器对象
 * 注意：扩展函数不能访问私有或保护属性
 *
 * 在底层，该函数是一个以接收器对象做第一个参数的静态方法
 */
fun String.lastChar(): Char = this[this.length - 1]

/**
 * 隐式this引用
 */
fun String.lastChar2(): Char = get(length - 1)

/**
 * 最终版的joinToString函数
 *
 * 扩展函数本质是静态函数调用的语法糖
 * 可以将泛型指定类型，例如指定了String，则其他类型都不能调用
 */
@JvmOverloads
fun <T> Collection<T>.joinToString(
        separator: String = ",",
        prefix: String = "",
        postfix: String = ""): String {
    val result = StringBuilder(prefix);
    for ((index, element) in withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }
    result.append(postfix)
    return result.toString()
}

open class View {
    open fun click() = println("click a view")
}

class Button : View() {
    override fun click() = println("click a button")
}

/**
 * 由于扩展方法是静态函数调用，所以扩展方法无法覆盖
 * 如果扩展函数和成员函数具有相同的签名，则成员函数具有高优先级
 */
fun View.showOff() = println("I am a view")

fun Button.showOff() = println("I am a button")

/**
 * 扩展属性
 * 不可变
 */
val String.theLastChar: Char
    get() = get(length - 1)

/**
 * 扩展属性
 * 可变
 */
var StringBuilder.theLastChar: Char
    get() = get(length - 1)
    set(c) = set(length - 1, c)


fun main(args: Array<String>) {
//    println("123".lastChar())

//    View().click()
//    Button().click()
//    val view: View = Button()
//    view.showOff()

//    println("Hello".lastChar())
//    println("Hello".theLastChar)
    val sb = StringBuilder("Kotlin?")
    println(sb)
    sb.theLastChar = '!'
    println(sb)
}
