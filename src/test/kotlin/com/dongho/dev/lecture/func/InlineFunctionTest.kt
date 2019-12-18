package com.dongho.dev.lecture.func

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

inline fun calculator(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)
inline fun calculato2(a: Int, b: Int, noinline op: (Int, Int) -> Int): Int = op(a, b)

fun apply1(op: () -> Unit) {
    println("start apply")
    op()
    println("end apply")
}

inline fun apply2(op: () -> Unit) {
    println("start apply")
    op()
    println("end apply")
}

class InlineFunctionTest {

    @Test
    @DisplayName("lambda Test")
    fun lambdaTest() {

        fun calculator(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)

        println(calculator(1, 2) {a, b -> a + b})
    }

    @Test
    @DisplayName("lambda Test 2")
    fun lambdaTest2() {

        fun calculator(a: Int, b: Int, op: Function2<Int, Int, Int>): Int {
            return op.invoke(a, b)
        }

        val op: Function2<Int, Int, Int> = { a, b -> a + b}

        println(calculator(1, 2, op))
    }

    @Test
    @DisplayName("inline lambda Test")
    fun inlineLambdaTest() {

        println(calculator(1, 2) {a, b -> a + b})
    }

    @Test
    @DisplayName("inline lambda Test2")
    fun inlineLambdaTest2() {

        println(calculator(1, 2) {a, b -> a + b})
    }

    @Test
    @DisplayName("non-local return Test")
    fun nonLocalReturnTest() {

        data class Person(val name: String, val age: Int)

        val people = listOf(Person("person1", 21), Person("person2", 22), Person("person3", 23))

        """
        start apply
        Find!
        """
        apply2 {
            for (person in people) {
                if (person.name == "person2") {
                    println("Find!")
                    return
                }
            }
            println("Not found")
        }
    }

    @Test
    @DisplayName("local return Test")
    fun localReturnTest() {

        data class Person(val name: String, val age: Int)

        val people = listOf(Person("person1", 21), Person("person2", 22), Person("person3", 23))

        """
        start apply
        Find!
        end apply
        """
        apply1 {
            for (person in people) {
                if (person.name == "person2") {
                    println("Find!")
                    return@apply1
                }
            }
            println("Not found")
        }
        /*
        apply1 label@ {
            for (person in people) {
                if (person.name == "person2") {
                    println("Find!")
                    return@label
                }
            }
            println("Not found")
        }*/
    }

    @Test
    @DisplayName("anonymous return Test")
    fun anonymousReturnTest() {
        data class Person(val name: String, val age: Int)

        val people = listOf(Person("person1", 21), Person("person2", 22), Person("person3", 23))

        """
        start apply
        Find!
        end apply
        """
        apply1 (fun() {
            for (person in people) {
                if (person.name == "person2") {
                    println("Find!")
                    return
                }
            }
            println("Not found")
        })
    }

}