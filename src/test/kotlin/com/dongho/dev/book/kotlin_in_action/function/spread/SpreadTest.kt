package com.dongho.dev.book.kotlin_in_action.function.spread

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class SpreadTest {

    @Test
    @DisplayName("spread Test")
    fun spreadTest() {
        val list = listOf("1", *(arrayOf("2", "3")))
        assertThat(list).containsExactly("1", "2", "3")
    }

}