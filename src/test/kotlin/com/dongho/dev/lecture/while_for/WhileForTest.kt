package com.dongho.dev.lecture.while_for

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class WhileForTest {

    @Test
    @DisplayName("in Test")
    fun inTest() {
        fun isLetter(c: Char) = c in 'a'..'z' || c in 'A'..'Z'
        fun isNotDigit(c: Char) = c !in '0'..'9'
        assertThat(isLetter('a')).isTrue()
        assertThat(isNotDigit('a')).isTrue()
        assertThat(isNotDigit('1')).isFalse()

        val coll = setOf("Hello", "World!")
        assertThat("Hello" in coll).isTrue()
        assertThat("World!" in coll).isTrue()
        assertThat("test" in coll).isFalse()
    }

    @Test
    @DisplayName("for with in test")
    fun forWithInTest() {
        var a: Int = 0

        // 1, 2, 3, 4, 5, 6, 7, 8, 9, 10
        for (i in 1..10) {
            a += i
        }
        assertThat(a).isEqualTo(55)

        // 10, 9, 8, 7, 6, 5, 4, 3, 2, 1
        for (i in 10 downTo 1) {
            a -= i
        }
        assertThat(a).isZero()

        // 1, 3, 5, 7, 9
        for (i in 1..10 step 2) {
            a += i
        }
        assertThat(a).isEqualTo(25)

        a = 30
        // 10, 8, 6, 4, 2
        for (i in 10 downTo 1 step 2) {
            a -= i
        }
        assertThat(a).isZero()

        var array: Array<Int> = arrayOf(1, 2, 3)
        for (i in 0 until array.size) {
            a += array[i]
        }
        assertThat(a).isEqualTo(6)
    }

}