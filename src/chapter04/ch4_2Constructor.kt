package chapter04

/**
 * 精简构造函数的类
 * Created by yupenglei on 17/7/14.
 */

class User422 constructor(_nickname: String) { //声明构造器
    val nickname: String //声明成员变量

    init {//初始化块
        nickname = _nickname
    }
}

class User423(_nickname: String) { //隐藏构造器
    val nickname = _nickname//隐藏初始块
}

class User421(val nickname: String)//最简化版本
class User424(val nickname: String, val isSubscribed: Boolean = true)//默认参数

open class User425(val nickname: String)
class TwitterUser426(nickname: String) : User425(nickname)//调用超类构造器

class Secretive427 private constructor()//构造器私有，无法被初始化
class Secretive428 {
    private constructor()//放在类内部
}

/**
 * 次构造函数
 */
open class View {
    constructor(ctx: String)
    constructor(ctx: String, attr: String)
}

class MyButton : View {
    constructor(ctx: String) : super(ctx)//调用超类构造器
    constructor(ctx: String, attr: String) : super(ctx, attr)
}

class MyButton2 : View {
    constructor(ctx: String) : this(ctx, "Hello")//调用本类构造器
    constructor(ctx: String, attr: String) : super(ctx, attr)
}


/**
 * 实现声明在接口中的属性
 */
interface User {
    val nickname: String//声明了一个属性
}

class PrivateUser(override val nickname: String) : User//使用主构造函数实现
class SubscribingUser(val email: String) : User {
    override val nickname: String
        get() = email.substringBefore("@")//自定义getter，没有存储，每次访问都要重新计算
}

class FackbookUser(val accountId: Int) : User {
    override val nickname = getFacebookName(accountId)//创建了一个字段来存储

    fun getFacebookName(accountId: Int): String = StringBuilder(accountId).toString()
}

/**
 * 通过getter和setter访问支持字段
 */
class User2(val name: String) {
    var address: String = "unspecified"
        set(value) {
            //field返回支持字段的值
            println("""
                Address was changed for $name:
                "$field"->"$value".
                """.trimIndent())
            field = value
        }
}

/**
 * 改变访问器的可见性
 */
class LengthCounter {
    var counter: Int = 0
        private set//设置变为私有

    fun addWord(word: String) {
        counter += word.length
    }
}

fun main(args: Array<String>) {
//    val user = User2("Alice")
//    user.address = "Beijing"
    val lengthCounter = LengthCounter()
    lengthCounter.addWord("Hello")
    println(lengthCounter.counter)
}
















