package chapter03

/**
 * 本地函数
 * Created by yupenglei on 17/7/14.
 */

class User(val id: Int, val name: String, val address: String)

/**
 * 保存user
 */
fun saveUser(user: User) {
    if (user.name.isEmpty()) {
        throw IllegalArgumentException("Can`t save user ${user.id}: Name is empty")
    }
    if (user.address.isEmpty()) {
        throw IllegalArgumentException("Can`t save user ${user.id}: Address is empty")
    }
}

/**
 * 使用本地函数
 */
fun saveUser2(user: User) {
    fun validate(user: User, value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user ${user.id}: $fieldName is empty")
        }
    }
//    validate(user, user.name, "Name")
//    validate(user, user.address, "Address")

    fun validate(value: String, fieldName: String) {//可以不传入user对象，因为本地函数可以访问外部函数
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user ${user.id}: $fieldName is empty")
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
}

/**
 * 在扩展函数中使用本地函数
 */
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("Can`t save user $id: $fieldName is empty")
        }
    }
    validate(name, "Name")
    validate(address, "Address")
}

/**
 * 扩展函数也可以声明为本地函数，放在函数内部，但会难以阅读
 */
fun saveUser3(user: User) {
    fun User.test() {
        fun validate(value: String, fieldName: String) {
            if (value.isEmpty()) {
                throw IllegalArgumentException("Can`t save user $id: $fieldName is empty")
            }
        }
        validate(name, "Name")
        validate(address, "Address")
    }
    user.test()
}

fun main(args: Array<String>) {
//    saveUser2(User(1, "Tom", ""))
//    User(1, "Tom", "").validateBeforeSave()
    saveUser3(User(3, "Tom", ""))
//    User(1,"","").test()
}
