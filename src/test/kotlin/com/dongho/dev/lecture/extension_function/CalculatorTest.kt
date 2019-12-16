package com.dongho.dev.lecture.extension_function

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Calculator {
    var lastResult: Int = 0

    fun sum(a: Int, b: Int): Int {
        lastResult = a + b
        return lastResult
    }
    fun minus(a: Int, b: Int): Int {
        lastResult = a - b
        return lastResult
    }
}

fun Calculator.sum(a: Int, b: Int, c: Int) = sum(a, b) + c
fun Calculator.minus(a: Int) = -a
fun Calculator.minus(a: Int, b: Int) = a + b // not override

// not having field.
val Calculator.signResult: Char
    get() = if (lastResult < 0) '-' else '+'

// extend java class function
fun CalculatorJava.sum(a: Int, b: Int, c: Int) = sum(a, b) + c
fun CalculatorJava.minus(a: Int) = -a

class CalculatorTest {

    @Test
    @DisplayName("class function test")
    fun classFunctionTest() {
        val calc = Calculator()

        assertThat(calc.sum(1, 2)).isEqualTo(3)
        assertThat(calc.minus(2, 1)).isEqualTo(1)
    }

    @Test
    @DisplayName("extension function test")
    fun extensionFunctionTest() {
        val calc = Calculator()

        assertThat(calc.sum(1, 2, 3)).isEqualTo(6)
        assertThat(calc.minus(1)).isEqualTo(-1)
        assertThat(calc.minus(2, 1)).isEqualTo(1)
    }

    @Test
    @DisplayName("extension property test")
    fun extensionPropertyTest() {
        val calc = Calculator()

        assertThat(calc.sum(1, 2)).isEqualTo(3)
        assertThat(calc.signResult).isEqualTo('+')

        assertThat(calc.minus(1, 2)).isEqualTo(-1)
        assertThat(calc.signResult).isEqualTo('-')
    }

    @Test
    @DisplayName("extension function test with Java Class")
    fun extensionFunctionTest2() {
        val calc = CalculatorJava()

        assertThat(calc.sum(1, 2, 3)).isEqualTo(6)
        assertThat(calc.minus(1)).isEqualTo(-1)
        assertThat(calc.minus(2, 1)).isEqualTo(1)
    }

}