package com.dongho.dev.book.kotlin_in_action.class_object_interface.sealed_class

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

private sealed class Expr2

private class Num2(val value: Int): Expr2()
private class Sum2(val left: Expr2, val right: Expr2): Expr2()

private fun eval(e: Expr2): Int =
    when(e) {
        is Num2 -> e.value
        is Sum2 -> eval(e.right) + eval(e.left)
    }


class SealedClassTest {

    @Test
    @DisplayName("sealed class Test")
    fun sealedClassTest() {
        assertThat(eval(Sum2(Sum2(Num2(1), Num2(2)), Num2(3)))).isEqualTo(6)
    }

}
