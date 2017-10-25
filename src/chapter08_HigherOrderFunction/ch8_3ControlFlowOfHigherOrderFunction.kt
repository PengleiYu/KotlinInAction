package chapter08_HigherOrderFunction

/**
 * 高阶函数控制流
 * Created by yupenglei on 17/10/13.
 */
/**
 * 局部返回
 * 标签
 */
fun testReturn() {
    (1..3).forEach lable@ { if (it == 2) return@lable }
    (1..3).forEach { if (it == 2) return@forEach }
    (1..3).forEach(
            fun(i) {
                if (i == 2) return
            }
    )
}