package com.dongho.dev.lecture.func

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

fun sum(a: Int, b: Int) : Int {
    return a + b
}

fun sub(a: Int, b: Int = 2) = a - b

class SumAndSubTest {

    @Test
    fun sumTest() {
        assertThat(sum(1, 2)).isEqualTo(3)
    }

    @Test
    fun subTest() {
        assertThat(sub(5)).isEqualTo(3)
        assertThat(sub(5, 4)).isEqualTo(1)
    }

}