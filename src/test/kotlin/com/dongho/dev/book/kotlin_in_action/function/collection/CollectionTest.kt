@file:JvmName("test")

package com.dongho.dev.book.kotlin_in_action.function.collection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

@JvmOverloads
fun <T> joinToString(collection: Collection<T>, separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in collection.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

@JvmOverloads
fun <T> java.util.Collection<T>.joinToString2(separator: String = ", ", prefix: String = "", postfix: String = ""): String {
    val result = StringBuilder(prefix)

    for ((index, element) in this.withIndex()) {
        if (index > 0) result.append(separator)
        result.append(element)
    }

    result.append(postfix)
    return result.toString()
}

fun Collection<String>.join(separator: String = ", ", prefix: String = "", postfix: String = "")
    = joinToString(this, separator, prefix, postfix)

class CollectionTest {

    @Test
    @DisplayName("joinToString Test")
    fun joinToStringTest() {
        val list = listOf(1, 2, 3)
        assertThat(joinToString(list, ", ")).isEqualTo("1, 2, 3")
        assertThat(joinToString(list, prefix = "(", postfix = ")")).isEqualTo("(1, 2, 3)")
        assertThat(joinToString(list, separator = "; ", prefix = "(", postfix = ")")).isEqualTo("(1; 2; 3)")
    }

    @Test
    @DisplayName("joinToString2 Test")
    fun joinToStringTest2() {
        val list = listOf(1, 2, 3)
        assertThat(list.joinToString(", ")).isEqualTo("1, 2, 3")
        assertThat(list.joinToString(prefix = "(", postfix = ")")).isEqualTo("(1, 2, 3)")
        assertThat(list.joinToString(separator = "; ", prefix = "(", postfix = ")")).isEqualTo("(1; 2; 3)")
    }

    @Test
    @DisplayName("join Test")
    fun joinTest2() {
        val list = listOf("1", "2", "3")
        assertThat(list.join(", ")).isEqualTo("1, 2, 3")
        assertThat(list.join(prefix = "(", postfix = ")")).isEqualTo("(1, 2, 3)")
        assertThat(list.join(separator = "; ", prefix = "(", postfix = ")")).isEqualTo("(1; 2; 3)")
    }

}