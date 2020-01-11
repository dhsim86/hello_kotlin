package com.dongho.dev.book.kotlin_in_action.basic.enum

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.test.assertFailsWith

enum class Color(val r: Int, val g: Int, val b: Int) {
    RED(255, 0, 0),
    ORANGE(255, 165, 0),
    YELLOW(255, 255, 0),
    GREEN(0, 255, 0),
    BLUE(0, 0, 255),
    INDIGO(75, 0, 130),
    VIOLET(238, 130, 238);

    fun rgb() = (r * 256 + g) * 256 + b
}

fun getMnemonic(color: Color) =
    when (color) {
        Color.RED -> "Richard"
        Color.ORANGE -> "Of"
        Color.YELLOW -> "York"
        Color.GREEN -> "Gave"
        Color.BLUE -> "Battle"
        Color.INDIGO -> "In"
        Color.VIOLET -> "Vain"
    }

fun getWarmth(color: Color) =
    when (color) {
        Color.RED, Color.ORANGE, Color.YELLOW -> "warm"
        Color.GREEN -> "neutral"
        Color.BLUE, Color.INDIGO, Color.VIOLET -> "cold"
    }

fun mix(c1: Color, c2: Color) =
    when (setOf(c1, c2)) {
        setOf(Color.RED, Color.YELLOW) -> Color.ORANGE
        setOf(Color.YELLOW, Color.BLUE) -> Color.GREEN
        setOf(Color.BLUE, Color.VIOLET) -> Color.INDIGO
        else -> throw Exception("Dirty Color")
    }

class EnumTest {

    @Test
    @DisplayName("enum rgb Test")
    fun enumRgbTest() {
        assertThat(Color.BLUE.rgb()).isEqualTo(255)
    }

    @Test
    @DisplayName("getMnemonic Test")
    fun getMnemonicTest() {
        assertThat(getMnemonic(Color.GREEN)).isEqualTo("Gave")
    }

    @Test
    @DisplayName("getWarmth Test")
    fun getWarmthTest() {
        assertThat(getWarmth(Color.ORANGE)).isEqualTo("warm")
    }

    @Test
    @DisplayName("mix Test")
    fun mixTest() {
        assertThat(mix(Color.BLUE, Color.YELLOW)).isEqualTo(Color.GREEN)
    }

    @Test
    @DisplayName("mix exception Test")
    fun mixExceptionTest() {
        assertFailsWith(Exception::class) {
            mix(Color.RED, Color.GREEN)
        }
    }

}