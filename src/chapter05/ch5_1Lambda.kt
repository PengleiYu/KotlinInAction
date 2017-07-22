package chapter05

/**
 * lambda表达式和成员引用
 * Created by JJBOOM on 2017/7/22.
 */

private fun test1() {
    var counter = 0
    run { counter++ }
    println(counter)
}

private data class Person(val name: String, val age: Int)

/**
 * 成员函数引用
 */
private fun salute() = println("Salute!")


private fun test2() {
    val list = listOf(Person("Tom", 11), Person("Jack", 22))
    println(list.maxBy { it.age })
    val getAge = Person::age
    println(list.minBy(Person::age))
    println(list.maxBy(getAge))

    salute()
    run { salute() }
    run(::salute)//顶层函数引用

    val createPerson = ::Person//构造函数引用
//    val createPerson2=Person::new //不能使用Java8形式
    val p = createPerson("Alice", 20)
    println(p)

    fun Person.isAdult() = age > 21
    val predicate = Person::isAdult //扩展函数引用
    println(predicate(p))

    val personAgeFunction = Person::age//成员函数引用
    println(personAgeFunction(p))
    val dmitrysAgeFunction = p::age//绑定函数引用，1.1后引入
    println(dmitrysAgeFunction())
}

fun main(args: Array<String>) {
    test2()
}
