package chapter02

import java.util.*

/**
 * 类和属性
 * Created by yupenglei on 17/7/13.
 */
//默认public
class Persion(val name: String)//值对象

/**
 * 自定义Getter
 */
class Rectangle(val height: Int, val width: Int) {
    val isSquare: Boolean
        get() {
            return height == width
        }
    val isSquare2: Boolean
        get() = width == height
}

fun createRandomRectangle(): Rectangle {
    val random = Random()
    return Rectangle(random.nextInt(), random.nextInt())
}

fun main(args: Array<String>) {
    val rect = Rectangle(20, 33)
    println(rect.isSquare)
}