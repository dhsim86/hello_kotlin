package com.dongho.dev.lecture.func

import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

inline fun calculator(a: Int, b: Int, op: (Int, Int) -> Int): Int = op(a, b)
inline fun calculato2(a: Int, b: Int, noinline op: (Int, Int) -> Int): Int = op(a, b)

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


}