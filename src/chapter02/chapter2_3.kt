package chapter02

/**
 * 表示和处理选择：枚举和when
 * Created by yupenglei on 17/7/13.
 */
enum class SimpleColor { RED, ORANGE, YELLOW, GREEN, BLUE, INDIGO, VIOLET }

enum class Color(var r: Int, var g: Int, var b: Int) {
    RED(255, 0, 0), ORANGE(255, 265, 0),
    YELLOW(255, 255, 0), GREEN(0, 255, 0), BLUE(0, 0, 255),
    INDIGO(75, 0, 130), VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

/**
 * when处理枚举
 */
fun getMnmonic(color: Color) =
        when (color) {
            Color.RED -> "Ricard"
            Color.ORANGE -> "of"
            Color.YELLOW -> "York"
            Color.GREEN -> "Grave"
            Color.BLUE -> "Battle"
            Color.INDIGO -> "In"
            Color.VIOLET -> "Vain"
        }

/**
 * 合并多个枚举项
 */
fun getWarmth(color: Color) =
        when (color) {
            Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
            Color.GREEN -> "neutral"
            Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
        }

/**
 * 对任意对象使用when
 */
fun mix(color1: Color, color2: Color) =
        when (setOf(color1, color2)) {
            setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
            setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
            setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
            else -> throw Exception("Dirty color")
        }

/**
 * 使用布尔表达式的when
 * 好处：不会创建额外的对象
 * 坏处：难以阅读
 */
fun mixOptimized(color1: Color, color2: Color) =
        when {
            (color1 == Color.RED && color2 == Color.YELLOW)
                    || (color1 == Color.YELLOW && color2 == Color.RED) -> Color.ORANGE
            (color1 == Color.YELLOW && color2 == Color.BLUE) ||
                    (color1 == Color.BLUE && color2 == Color.YELLOW) -> Color.GREEN

            (color1 == Color.BLUE && color2 == Color.VIOLET) ||
                    (color1 == Color.VIOLET && color2 == Color.BLUE) -> Color.INDIGO

            else -> throw Exception("Dirty color")
        }

/**
 * 智能类型转换：合并类型检查和转换
 */

interface Expr

class Num(val value: Int) : Expr //实现了接口
//接收两个Expr
class Sum(val left: Expr, val right: Expr) : Expr

fun evalPre1(expr: Expr): Int {
    if (expr is Num) {
        return expr.value//智能类型转换
    }
    if (expr is Sum) {
        return evalPre1(expr.left) + evalPre1(expr.right)
    }
    throw IllegalArgumentException("Unknown expression")
}

/**
 * 表达式主体
 */
fun eval_pre2(expr: Expr): Int =
        (expr as? Num)?.value ?: if (expr is Sum) {
            eval_pre2(expr.left) + eval_pre2(expr.right)
        } else
            throw IllegalArgumentException("Unknown expression")

/**
 * 用when代替if
 */
fun eval(expr: Expr): Int =
        when (expr) {
            is Num -> expr.value
            is Sum -> eval(expr.left) + eval(expr.right)
            else -> throw IllegalArgumentException("Unknown expression")
        }

/**
 * when和if都可以使用代码块做分支
 */
fun evalWithLogging(expr: Expr): Int =
        when (expr) {
            is Num -> {
                println("num: ${expr.value}")
                expr.value
            }
            is Sum -> {
                val left = evalWithLogging(expr.left)
                val right = evalWithLogging(expr.right)
                val sum = left + right
                println("sum: $left+$right=$sum")
                sum
            }
            else -> throw IllegalArgumentException("Unknown expression")
        }

fun main(args: Array<String>) {
//    println(getMnmonic(Color.RED))
//    println(getWarmth(Color.ORANGE))
//    println(mix(Color.BLUE, Color.YELLOW))
    println(evalWithLogging(Sum(Sum(Num(1), Num(2)), Num(4))))
}