package chapter11_DSL.ch11_3InvokeScheme

/**
 * 使用invoke约定构建更灵活的代码块嵌套
 * Created by yupenglei on 17/11/2.
 */

//===========================invoke约定和函数式类型======================
private data class Issue(val id: String, val project: String, val type: String,
                         val priority: String, val description: String)

/**
 * 函数类型居然也可以是基类类型
 *
 * 先接受一些参数，相当于配置文件，然后在作为函数接收参数
 */
private class ImportantIssuesPredicate(val project: String) : (Issue) -> Boolean {
    /**
     * 函数执行前先检查配置文件
     */
    override fun invoke(issue: Issue): Boolean =
            issue.project == project && issue.isImportant()

    /**
     * 这个才是important的主体函数
     */
    private fun Issue.isImportant(): Boolean =
            type == "Bug" && (priority == "Major" || priority == "Critical")
}

private fun test1() {
    val issue1 = Issue("IDEA-154446", "IDEA", "Bug", "Major",
            "Save settings failed")
    val issue2 = Issue("KT 12183", "Kotlin", "Feature", "Normal",
            "Intention: convert several calls on the same receiver to with/apply")
    val predicate = ImportantIssuesPredicate("IDEA")
    for (i in listOf(issue1, issue2).filter(predicate))
        println(i)
}

//===========================在Gradle中声明依赖====================
private class DependencyHandler {
    fun compile(coordinate: String) {
        println("Add dependency on $coordinate")
    }

    /**
     * 接收一个自身的扩展函数
     */
    operator fun invoke(body: DependencyHandler.() -> Unit) {
        body()
    }
}

private fun test2() {
    val dependency = DependencyHandler()
    // 同时支持扁平结构和嵌套代码块
    dependency.compile("lib1")
    dependency {
        compile("lib2")
        compile("lib3")
    }
}

fun main(args: Array<String>) {
    test2()
}
