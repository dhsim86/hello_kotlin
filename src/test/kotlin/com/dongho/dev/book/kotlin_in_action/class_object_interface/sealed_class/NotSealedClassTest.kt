package com.dongho.dev.book.kotlin_in_action.class_object_interface.sealed_class

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException

private interface Expr

private class Num(val value: Int): Expr
private class Sum(val left: Expr, val right: Expr): Expr

private fun eval(e: Expr): Int =
    when(e) {
        is Num -> e.value
        is Sum -> eval(e.left) + eval(e.right)
        else -> throw IllegalArgumentException("Unknown expression")
    }

class NotSealedClassTest {

    @Test
    @DisplayName("Expr Test")
    fun exprTest() {
        assertThat(eval(Sum(Sum(Num(1), Num(2)), Num(3)))).isEqualTo(6)
    }

}