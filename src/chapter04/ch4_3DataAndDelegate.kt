package chapter04

/**
 * 编译器生成的方法
 * 数据类
 * Created by yupenglei on 17/7/14.
 */
class Client(val name: String, val postalCode: Int)

class Client2(val name: String, val postalCode: Int) {
    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
}

class Client3(val name: String, val postalCode: Int) {

    override fun equals(other: Any?): Boolean {
        if (other == null || other !is Client3) {
            return false
        }
        return name == other.name && postalCode == other.postalCode
    }

    override fun toString(): String = "Client(name=$name, postalCode=$postalCode)"
}

fun main(args: Array<String>) {
//    println(Client("Tom", 11))
//    println(Client2("Tom", 11))
    val client1 = Client("Tom", 11)
    val client2 = Client("Tom", 11)
    println(client1 == client2)
    val client3 = Client3("Tom", 12)
    val client4 = Client3("Tom", 12)
    println(client3 == client4)
    val set = setOf(Client3("Kat", 22))
    println(set.contains(Client3("Kat", 22)))//似乎不覆盖hashcode也返回true
    val client5 = Client4("Tom", 22)
    client5.copy(postalCode = 11)
}


/**
 * data类
 */
data class Client4(val name: String, val postalCode: Int)//注意只有在主构造函数中声明的成员才参与equals和hashcode

/**
 * 不可变性
 * data类作为不可变类，编译器添加了一个copy方法可以复制一个实例、改变某些属性
 * 以下是自己实现
 */
class Client5(val name: String, val postalCode: Int) {
    fun copy(name: String = this.name, postalCode: Int = this.postalCode)
            = Client5(name, postalCode)
}

/**
 * 委托类
 * 只能委托接口
 */
interface MyInterface {
    fun hello()
}

class MyClass : MyInterface {
    override fun hello() {
        println("Hello")
    }
}

class DelegatingClass(myClass: MyInterface = MyClass()) : MyInterface by myClass

class CountingSet<T>(val innerSet: MutableCollection<T> = HashSet<T>())
    : MutableCollection<T> by innerSet {
    var objectsAdded = 0
    override fun add(element: T): Boolean {
        objectsAdded++
        return innerSet.add(element)
    }

    override fun addAll(elements: Collection<T>): Boolean {
        objectsAdded += elements.size
        return innerSet.addAll(elements)
    }
}