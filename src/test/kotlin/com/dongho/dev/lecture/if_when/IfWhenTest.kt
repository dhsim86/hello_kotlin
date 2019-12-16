package com.dongho.dev.lecture.if_when

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class IfWhenTest {

    @Test
    @DisplayName("if assign Test")
    fun ifAssignTest() {
        val a = 1
        val b = 2

        var max = if (a < b) b else a
        assertThat(max).isEqualTo(2)

        fun getMax(a: Int, b: Int) = if (a < b) b else a
        assertThat(getMax(3, 2)).isEqualTo(3)
    }

    @Test
    @DisplayName("when test")
    fun whenTest() {
        val a = 1

        when (a) {
            1 -> println("a")
            2 -> println("b")
            else -> println("c")
        }

        // a
    }

    @Test
    @DisplayName("when return test")
    fun whenReturnTest() {
        fun whenReturn(a: Int): String {
            return when(a) {
                1 -> "a"
                2 -> "b"
                3, 4 -> "c"
                else -> "d"
            }
        }

        assertThat(whenReturn(1)).isEqualTo("a")
        assertThat(whenReturn(2)).isEqualTo("b")
        assertThat(whenReturn(3)).isEqualTo("c")
        assertThat(whenReturn(4)).isEqualTo("c")
        assertThat(whenReturn(5)).isEqualTo("d")
    }

    @Test
    @DisplayName("when return with function call test")
    fun whenReturnWithFunctionCallTest() {
        fun whenReturn(a: Int, str: String): Boolean {
            return when(a) {
                str.toInt() -> true
                else -> false
            }
        }

        assertThat(whenReturn(10, "10")).isTrue()
        assertThat(whenReturn(10, "20")).isFalse()
    }

    @Test
    @DisplayName("when range test")
    fun whenRangeTest() {
        fun whenReturn(a: Int): Int {
            return when(a) {
                in 1..10 -> 1
                in 10..20 -> 2
                else -> 0
            }
        }

        assertThat(whenReturn(10)).isEqualTo(1)
        assertThat(whenReturn(11)).isEqualTo(2)
        assertThat(whenReturn(21)).isEqualTo(0)
    }

    @Test
    @DisplayName("when smart cast test")
    fun whenSmartCastTest() {
        fun whenReturn(x: Any) = when (x) {
            is String -> x.startsWith("prefix")
            else -> false
        }

        assertThat(whenReturn("prefixA")).isTrue()
        assertThat(whenReturn("pre")).isFalse()
        assertThat(whenReturn(5)).isFalse()
    }

    @Test
    @DisplayName("when without arg test")
    fun whenWithoutArgTest() {
        fun Int.isOdd() = if (this % 2 == 0) false else true
        fun Int.isEven() = if (this % 2 == 0) true else false

        fun whenReturn(x: Int) = when {
            x.isOdd() -> "odd"
            x.isEven() -> "even"
            else -> ""
        }

        assertThat(whenReturn(1)).isEqualTo("odd")
        assertThat(whenReturn(2)).isEqualTo("even")
    }

}