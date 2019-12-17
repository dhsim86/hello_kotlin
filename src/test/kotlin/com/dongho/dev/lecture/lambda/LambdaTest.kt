package com.dongho.dev.lecture.lambda

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class LambdaTest {

    @Test
    @DisplayName("lambda test")
    fun lambdaTest() {
        //var sum: (Int, Int) -> Int = { x, y -> x + y }
        val sum = { x: Int, y: Int -> x + y }

        assertThat(sum(1, 2)).isEqualTo(3)
    }

    @Test
    @DisplayName("anonymous test")
    fun anonymousTest() {
        fun calculator(a: Int, b: Int, p: (Int, Int) -> Int): Int {
            return p(a, b)
        }
        assertThat(calculator(1, 2) { a: Int, b: Int -> a + b }).isEqualTo(3)
        assertThat(calculator(1, 2) { a, b -> a - b }).isEqualTo(-1)

        fun applier(a: Int, p: (Int) -> Int): Int {
            return p(a)
        }
        assertThat(applier(2) { it * it }).isEqualTo(4)

        fun supplier(p: () -> Any): Any {
            return p()
        }
        assertThat(supplier { emptyList<String>() }).isInstanceOf(List::class.java)

        fun predicator(p: (() -> Boolean)? = null): Boolean {
            return p?.invoke() ?: false
        }
        assertThat(predicator { 2 == 2 }).isEqualTo(true)
        assertThat(predicator { 2 != 2 }).isEqualTo(false)
        assertThat(predicator()).isEqualTo(false)
    }

    @Test
    @DisplayName("lambda assignment test")
    fun lambdaAssignmentTest() {
        fun calculator(a: Int, b: Int, p: (Int, Int) -> Int): Int {
            return p(a, b)
        }

        fun sum(a: Int, b: Int) = a + b
        val sumFunctor = { x: Int, y: Int -> x + y }

        assertThat(calculator(1, 2) { a: Int, b: Int -> a + b }).isEqualTo(3)
        assertThat(calculator(1, 2, ::sum)).isEqualTo(3)
        assertThat(calculator(1, 2, sumFunctor)).isEqualTo(3)
    }

}