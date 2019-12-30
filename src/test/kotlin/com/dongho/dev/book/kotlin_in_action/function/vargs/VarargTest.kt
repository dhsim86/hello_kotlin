package com.dongho.dev.book.kotlin_in_action.function.vargs

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

fun sumAll (vararg values: Int) = values.sum()

class VarargTest {

    @Test
    @DisplayName("varargs Test")
    fun varargsTest() {
        assertThat(sumAll(1, 2, 3)).isEqualTo(6)
        assertThat(sumAll(1, 2, 3, 4, 5)).isEqualTo(15)
    }

}