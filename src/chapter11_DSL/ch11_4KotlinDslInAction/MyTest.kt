package chapter11_DSL.ch11_4KotlinDslInAction

import io.kotlintest.matchers.endWith
import io.kotlintest.matchers.should
import io.kotlintest.matchers.shouldBe
import io.kotlintest.matchers.startWith
import io.kotlintest.properties.forAll
import io.kotlintest.properties.headers
import io.kotlintest.properties.row
import io.kotlintest.properties.table
import io.kotlintest.specs.StringSpec

/**
 * Created by yupenglei on 17/11/2.
 */
/**
 * KotlinTest的用法
 */
class MyTest : StringSpec() {
    init {
        "length should return size of string" {
            "hello".length shouldBe 5
        }

        "should add"{
            val myTable = table(
                    headers("a", "b", "result"),
                    row(1, 2, 3),
                    row(1, 1, 2)
            )

            forAll(myTable) {
                a, b, result ->
                a + b shouldBe result
            }
        }

        "test print"{
            println("Hello world")
        }
        "test function"(this::hello)

        "string size"{
            forAll { a: String, b: String ->
                (a + b).length == a.length + b.length
            }
        }
        "test should"{
            "kotlin" should startWith("kot")
        }
    }

    fun hello() {
        println("Hello")
    }
}
