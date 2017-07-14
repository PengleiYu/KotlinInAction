package chapter03

/**
 * 字符串和正则表达式
 * Created by yupenglei on 17/7/13.
 */

fun main(args: Array<String>) {
    /**
     * 拆分字符串
     * 必须传入Regex对象
     */
    //    println("12.345-6.A".split("[.-]".toRegex()))
//    println("12.345-6.A".split(".", "-"))

//    val path = "/Users/yole/kotlin-book/chapter.adoc"
//    parsePath(path)

    println(kotlinLogo.trimMargin("."))
    println(kotlinLogo2.trimIndent())
    println("""c:\adhf\asdlf\sdfj""")
    println(hello.trimMargin("."))
    println(price1)
    println(price2)
}

/**
 * 使用扩展函数
 */
fun parsePath(path: String) {
    val directory = path.substringBeforeLast("/")
    val fullName = path.substringAfterLast("/")
    val fileName = fullName.substringBeforeLast(".")
    val extension = fullName.substringAfterLast(".")
    println("Dir: $directory, name: $fileName, ext: $extension")
}

/**
 * 使用正则
 */
fun parsePathRegexp(path: String) {
    val regex = """(.+)/(.+)\.(.+)""".toRegex()//创建正则
    val matchResult = regex.matchEntire(path)//进行匹配
    if (matchResult != null) {
        val (directory, fileName, extension) = matchResult.destructured//解构
        println("Dir: $directory, name: $fileName, ext: $extension")
    }
}

/**
 * 三双引号
 * 所见即所得
 * 可添加一个前缀到
 */
val kotlinLogo = """| //
                    .|//
                    .|/ \"""
val kotlinLogo2 = """
                    | //
                    |//
                    |/ \"""
val hello =
        """Hello
        .world"""

/**
 * 在三引号中引用变量
 */
val price1 = """${'$'}99.9"""
val price2 = """${hello.trimMargin(".")}99.9"""
