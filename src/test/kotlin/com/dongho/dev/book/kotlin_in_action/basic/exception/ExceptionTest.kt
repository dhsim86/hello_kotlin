package com.dongho.dev.book.kotlin_in_action.basic.exception

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.lang.IllegalArgumentException
import kotlin.test.assertFailsWith

class ExceptionTest {

    @Test
    @DisplayName("exception expression Test")
    fun exceptionExpressionTest() {
        val number = 10

        val percentage =
            if (number in 0..100)
                number
            else
                throw IllegalArgumentException("percentage must be between 0 and 100: ${number}")

        assertThat(percentage).isEqualTo(10)
    }

    @Test
    @DisplayName("exception expression throw Test")
    fun exceptionExpressionThrowTest() {
        val number = -1

        var percentage = 0

        assertFailsWith(IllegalArgumentException::class) {
            percentage =
                if (number in 0..100)
                    number
                else
                    throw IllegalArgumentException("percentage must be between 0 and 100: ${number}")
        }

        assertThat(percentage).isZero()
    }

}