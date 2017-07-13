package chapter01

/**
 * Created by yupenglei on 17/7/12.
 */
data class Person(val name: String = "Hello", //默认值
                  val age: Int? = null)//可为空

fun main(args: Array<String>) {
    val persons = listOf(Person(name = "Alice"), Person("Bob", 23))
    val oldest = persons.maxBy { it.age ?: 0 }
    println("The oldest is $oldest")
}
