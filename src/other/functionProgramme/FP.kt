package other.functionProgramme

/**
 * Created by yupenglei on 18/1/19.
 */

/**
 * 取集合的幂集
 */

/**
 * 第一版
 */
private fun <T> powerSet1(set: Collection<T>): Set<Set<T>> {
    if (set.isEmpty()) return setOf(setOf())
    val first = set.first()
    val powerSetRest = powerSet1(set.drop(1)).toSet()
    return powerSetRest + powerSetRest.map { it + first }
}

/**
 * 第二版
 */
private fun <T> powerSet2(set: Collection<T>): Set<Set<T>> =
        if (set.isEmpty()) setOf(setOf())
        else powerSet2(set.drop(1)).let { it + it.map { it + set.first() } }

/**
 * 第三版
 */
private fun <T> Collection<T>.powerSet3(): Set<Set<T>> =
        if (isEmpty()) setOf(setOf())
        else drop(1).powerSet3().let { it + it.map { it + first() } }

/**
 * 尾递归版本
 * 第四版
 */
private fun <T> Collection<T>.powerSet4(): Set<Set<T>> = powerSet5(this, setOf(setOf()))

tailrec fun <T> powerSet5(left: Collection<T>, acc: Set<Set<T>>): Set<Set<T>> =
        if (left.isEmpty()) acc
        else powerSet5(left.drop(1), acc + acc.map { it + left.first() })

/**
 * 快速排序
 * 递归
 */
private fun <T : Comparable<T>> List<T>.quickSort(): List<T> =
        if (size < 2) this
        else {
            val pivot = first()
            val (smaller, greater) = drop(1).partition { it < pivot }
            smaller.quickSort() + pivot + greater.quickSort()
        }

fun main(args: Array<String>) {
    val set = setOf(1, 2, 3)
//    println(powerSet1(set))
//    println(powerSet2(set))
//    println(set.powerSet3())
//    println(set.powerSet4())

    val list = listOf(6, 2, 9, 3, 7, 0, 4, 1)
    println(list.quickSort())
}