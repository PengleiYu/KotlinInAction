package chapter04

/**
 * 定义类层级
 * Created by yupenglei on 17/7/14.
 */

/**
 * 接口：带默认实现的方法
 */
interface Clickable {
    fun click()
    fun showOff() = println("I`m clickable!")//默认方法，无需default
}

class Button2 : Clickable { //继承类
    override fun click() = println("I`m click")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lose"} focus.")
    fun showOff() = println("I`m focusable!")
}

class Button3 : Clickable, Focusable {
    override fun showOff() {//继承的成员有超过一个实现，则必须显示提供一个实现
        super<Clickable>.showOff()//尖括号限定超类
        super<Focusable>.showOff()
    }

    override fun click() = println("I was clicked")
}

fun main(args: Array<String>) {
//    val button = Button2()
//    button.showOff()
//    button.click()
    val button = Button3()
    button.click()
    button.showOff()
    button.setFocus(false)
}

/**
 * open,final,abstract修饰符
 */
open class RichButton : Clickable {
    fun disable() {}//final
    open fun animate() {}//开放
    override fun click() {}//开放，可添加final变为不可修改
}

/**
 * 可见性修饰符
 */
internal open class TalkativeButton : Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let`s talk!")
}

//fun TalkativeButton.giveSpeech() {//默认是public，高可见性成员不能引用低可见性外部类
//    yell()//private只能被内部访问，扩展函数无法访问
//
//    whisper()//protected只能被子类访问，扩展函数无法访问
//}

/**
 * 内部类和嵌套类
 */
class Outer1 {
    inner class Inner { //内部类必须声明inner
        fun getOuterReference(): Outer1 = this@Outer1//内部类引用外部类的语法
    }

    class Inner2 {}//其实是静态内部类，即嵌套类，未持有外部对象
}

/**
 * 密封类
 * 通常和when配合使用
 * 枚举的扩展，枚举每个类型只能有一个实例，但密封类的每个类型都可以有多个实例
 */
interface Expr1

class Num1(val value: Int) : Expr1
class Sum1(val left: Expr1, val right: Expr1) : Expr1

fun eval1(e: Expr1): Int = when (e) {
    is Num1 -> e.value
    is Sum1 -> eval1(e.left) + eval1(e.right)
    else -> throw IllegalArgumentException("Unknown expression")
}

sealed class Expr2 {
    class Num2(val value: Int) : Expr2()//嵌套类，也可以是inner
}

class Sum2(val left: Expr2, val right: Expr2) : Expr2()//现在密封类的子类可以放在外面了

fun eval2(e: Expr2): Int = when (e) {//不再需要else了
    is Expr2.Num2 -> e.value
    is Sum2 -> eval2(e.left) + eval2(e.right)
}
