package chapter11_DSL.ch11_3InvokeScheme

import chapter03.joinToString

/**
 * 玩具版的HTML DSL
 * Created by yupenglei on 17/11/1.
 */
open class Tag(val name: String) {
    private val children = mutableListOf<Tag>()
    /**
     * 调用lambda，并保存子标签的引用
     */
    protected fun <T : Tag> doInit(child: T, init: T.() -> Unit) {
        children.add(child.apply(init))
    }

    override fun toString(): String =
            "<$name>${children.joinToString("")}</$name>"
}

private fun table(init: TABLE.() -> Unit) = TABLE().apply(init)

class TABLE : Tag("table") {
    fun tr(init: TR.() -> Unit) = doInit(TR(), init)
}

class TR : Tag("tr") {
    fun td(init: TD.() -> Unit) = doInit(TD(), init)
}

class TD : Tag("td")


private fun createTable() =
        table { tr { td { } } }

fun main(args: Array<String>) {
    val s = table {
        for (i in 1..4)
            tr { td { } }
    }
    println(s)
}
