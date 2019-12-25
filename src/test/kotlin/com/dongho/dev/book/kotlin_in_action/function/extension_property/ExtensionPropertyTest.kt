@file:JvmName("ExtensionProperty")

package com.dongho.dev.book.kotlin_in_action.function.extension_property

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

val String.lastChar: Char
    get() = get(length - 1)

var StringBuilder.lastChar: Char
    get() = get(length - 1)
    set(value: Char) {
        this.setCharAt(length - 1, value)
    }

class ExtensionPropertyTest {

    @Test
    @DisplayName("extensionProperty Test")
    fun extensionPropertyTest() {
        val sb = StringBuilder("Hello Kotlin?")
        sb.lastChar = '!'

        assertThat(sb.toString()).isEqualTo("Hello Kotlin!")
    }

}