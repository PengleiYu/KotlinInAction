package chapter11_DSL.ch11_4KotlinDslInAction

import java.time.LocalDate
import java.time.Period

/**
 * Created by yupenglei on 17/11/2.
 */

/**
 * 类似英语的问法
 */
private fun test1() {
    "Hello" should startWith("H")
    "Hello".should(startWith("H"))
}

private interface Matcher<in T> {
    fun test(value: T)
}

private class startWith(val prefix: String) : Matcher<String> {
    override fun test(value: String) {
        if (!value.startsWith(prefix)) throw AssertionError("String $value does not start with $prefix")
    }

}

private infix fun <T> T.should(matcher: Matcher<T>) = matcher.test(this)

/**
 * 更自然和复杂的文法
 */
private fun test2() {
    "kotlin" should start with "kot"
}

private object start

private infix fun String.should(x: start): StartWrapper = StartWrapper(this)
private class StartWrapper(val value: String) {
    infix fun with(prefix: String) {
        if (!value.startsWith(prefix)) throw AssertionError("String $value does not start with $prefix")
    }

}

/**
 * 处理日期
 */
private fun test3() {
    println(0.days.ago)
    println(1.days.ago)
    println(1.days.fromNow)
}

private val Int.days: Period
    get() = Period.ofDays(this)
private val Period.ago: LocalDate
    get() = LocalDate.now() - this

private val Period.fromNow: LocalDate
    get() = LocalDate.now() + this

fun main(args: Array<String>) {
    test3()
}