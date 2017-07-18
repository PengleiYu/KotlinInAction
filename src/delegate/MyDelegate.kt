package delegate

import kotlin.properties.Delegates
import kotlin.properties.ReadOnlyProperty
import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

/**
 * @link https://www.kotlincn.net/docs/reference/delegated-properties.html#委托属性
 * Created by yupenglei on 17/7/18.
 */

/**
 * 委托属性
 */
private class MyDelegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name} in $thisRef.'")
    }
}

class Example {
    var p: String by MyDelegate()
}

private fun test1() {
    val e = Example()
    e.p = "Hello"
    println(e.p)
}

/**
 * 标准委托
 * 延迟属性
 * 自1.1后可以局部委托属性
 */
private val lazyValue: String by lazy {
    println("computed!")
    "Hello"
}

private fun test2() {
    println(lazyValue)
    println(lazyValue)
}

/**
 * 可观察属性
 */
private var name: String by Delegates.observable("null") {
    property, oldValue, newValue ->
    println("$property-$oldValue->$newValue")
}

private fun test3() {
    name = "Hello"
    name = "World"
}

/**
 * 可否决属性
 */
private var age: Int by Delegates.vetoable(0) {
    property, oldValue, newValue ->
    println("$property-$oldValue->$newValue")
    newValue > 0
}

private fun test4() {
    age = 5
    age = -4
    age = 9
}

/**
 * 属性存储在map中
 */
private class User(map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

private class User2(map: MutableMap<String, Any?>) {
    val name: String by map
    var age: Int by map
}

private fun test5() {
    val user = User(mapOf("name" to "Tom", "age" to 44))
    println("${user.name} -> ${user.age}")
    val user2 = User2(mutableMapOf("name" to "Tom", "age" to 44))
    println("${user2.name} -> ${user2.age}")
    user2.age = 22
    println("${user2.name} -> ${user2.age}")
}

/**
 * 属性委托的要求
 * getValue和setValue可以来自标准库接口
 * 注意thisRef的类型，对象委托属性和局部委托属性不一样
 */
private class Example2 {
    val name: String by MyDelegate2()
}

private var name3: String by MyDelegate3()

private class MyDelegate2 : ReadOnlyProperty<Example2, String> {
    override fun getValue(thisRef: Example2, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }
}

private class MyDelegate3 : ReadWriteProperty<Nothing?, String> {
    override fun setValue(thisRef: Nothing?, property: KProperty<*>, value: String) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun getValue(thisRef: Nothing?, property: KProperty<*>): String {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}


/**
 * 绑定属性前检查属性名称
 * 需要显式传递属性名称
 */
private class MyUI {
    val image by bindResource(ResourceID.img_id, "image")
    val text by bindResource(ResourceID.text_id, "text")
}

private enum class ResourceID {
    img_id, text_id
}

private fun checkProperty(thisRef: MyUI, name: String) {
    TODO()
}

private fun <T> MyUI.bindResource(id: T, propertyName: String)
        : ReadOnlyProperty<MyUI, T> {
    checkProperty(this, propertyName)
    return object : ReadOnlyProperty<MyUI, T> {
        override fun getValue(thisRef: MyUI, property: KProperty<*>): T {
            TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
        }
    }
}

/**
 * 使用provideDelegate拦截属性
 * 不是太懂
 */
private class ResourceLoader<T>(id: T) {
    operator fun provideDelegate(thisRef: MyUI2, property: KProperty<*>)
            : ReadOnlyProperty<MyUI2, T> {
        checkProperty(thisRef, property.name)
        return object : ReadOnlyProperty<MyUI2, T> {
            override fun getValue(thisRef: MyUI2, property: KProperty<*>): T {
                TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
            }
        }
    }

    private fun checkProperty(thisRef: MyUI2, name: String) {}
}

private fun <T> MyUI2.bindResource(id: T) = ResourceLoader(id)

private class MyUI2 {
    val img by bindResource(ResourceID.img_id)
    val text by bindResource(ResourceID.text_id)
}

fun main(args: Array<String>) {
    test1()
}