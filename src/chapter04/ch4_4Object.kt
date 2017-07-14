package chapter04

import java.io.File

/**
 * Created by yupenglei on 17/7/14.
 */
class Person

/**
 * 单例模式
 */
object Payroll {
    val allEmployees = arrayListOf<Person>()
    fun calculateSalary() {
        for (person in allEmployees) {
        }
    }
}

object CaseInsensitiveFileComparator : Comparator<File> {
    override fun compare(o1: File, o2: File): Int {
        return o1.path.compareTo(o2.path, true)
    }
}

fun testObject() {
//    Payroll.allEmployees.add(Person())
//    Payroll.calculateSalary()

    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    val files = listOf(File("/Z"), File("/a"))
    println(files.sortedWith(CaseInsensitiveFileComparator))
}

data class Person2(val name: String) {
    object NameComparator : Comparator<Person2> {
        override fun compare(o1: Person2, o2: Person2): Int = o1.name.compareTo(o2.name)
    }
}

fun testPerson() {
    val persons = listOf(Person2("Bob"), Person2("Alice"))
    println(persons.sortedWith(Person2.NameComparator))
}

/**
 * 伴生对象
 */
class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class User3 {
    val nickname: String

    constructor(email: String) {
        nickname = email.substringBefore("@")
    }

    constructor(facebookId: Int) {
        nickname = getFacebookName(facebookId)
    }

}

fun getFacebookName(id: Int): String = StringBuilder().append(id).toString()
/**
 * 工厂实现
 */
class User4(val nickname: String) {
    companion object {
        fun newSubscribingUser(email: String) = User4(email.substringBefore("@"))
        fun newFacebookUser(accountId: Int) = User4(getFacebookName(accountId))
    }
}

fun test442() {
//    A.bar()
    val user = User4.newFacebookUser(1111)
    val user2 = User4.newSubscribingUser("Tom@qq.mail")
    println("${user.nickname}  ${user2.nickname}")
}

/**
 * 伴生对象是个常规对象
 */
class Person3(val name: String) {
    companion object Loader {//为伴生对象添加名字
        fun fromJson(josn: String): Person3 = Person3("")
    }
}

fun main(args: Array<String>) {
//    testPerson()
    test442()
}