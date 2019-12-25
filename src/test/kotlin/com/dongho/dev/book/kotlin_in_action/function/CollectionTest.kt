@file:JvmName("test")

package com.dongho.dev.book.kotlin_in_action.function

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

class CollectionTest {

    @Test
    @DisplayName("joinToString Test")
    fun joinToStringTest() {
        val list = listOf(1, 2, 3)
        assertThat(joinToString(list, ", ")).isEqualTo("1, 2, 3")
        assertThat(joinToString(list, prefix = "(", postfix = ")")).isEqualTo("(1, 2, 3)")
        assertThat(joinToString(list, separator = "; ", prefix = "(", postfix = ")")).isEqualTo("(1; 2; 3)")
    }

}