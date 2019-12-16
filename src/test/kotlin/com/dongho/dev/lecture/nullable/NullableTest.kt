package com.dongho.dev.lecture.nullable

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

import kotlin.test.assertFailsWith

class Bitmap(val width: Int, val height: Int) {
    val size: Int
        get() = width * height

    val map = ByteArray(size)
}

fun createBitmap(width: Int, height: Int): Bitmap? {
    if (width > 0 && height > 0) {
        return Bitmap(width, height)
    }
    return null
}

class NullableTest {

    @Test
    @DisplayName("nullable test")
    fun nullableTest() {
        val bitmap: Bitmap? = createBitmap(10, 10)
        assertThat(bitmap?.size).isEqualTo(100)
    }

    @Test
    @DisplayName("nullable test with Null")
    fun nullableTestWithNull() {
        val bitmap: Bitmap? = createBitmap(0, 0)

        // must null check with (?.) operator
        // if bitmap is null, it will return null
        assertThat(bitmap?.size).isNull()
    }

    @Test
    @DisplayName("nullable test with Null and elvis")
    fun nullableTestWithNullAndElvis() {
        val bitmap: Bitmap? = createBitmap(0, 0)

        // if bitmap is null, it will return default value. (100)
        assertThat(bitmap?.size ?: 100).isEqualTo(100)
    }

    @Test
    @DisplayName("nullable test with Null and Exception")
    fun nullableTestWithNullAndException() {
        val bitmap: Bitmap? = createBitmap(0, 0)

        // if bitmap is null, throw illegalException
        assertFailsWith(IllegalStateException::class) {
            bitmap?.size ?: throw IllegalStateException("null")
        }
    }

}