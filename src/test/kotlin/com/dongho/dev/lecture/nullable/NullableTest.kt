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

fun drawBitmap(bitmap: Bitmap) {
    println("drawBitmap")
}

class Address(val st: String, val zipCode: Int, var city: String)
class Company(val name: String, val addr: Address?)
class Person(val name: String, val company: Company?)


class NullableTest {

    @Test
    @DisplayName("nullable test with If")
    fun nullableTestIf() {
        val bitmap: Bitmap? = createBitmap(10, 10)

        if (bitmap != null) {
            assertThat(bitmap.size).isEqualTo(100)
        }
    }

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

    @Test
    @DisplayName("nullable chaining Test")
    fun nullableChainingTest() {
        val person = Person("test", null)

        assertThat(person?.company?.addr).isNull()
    }

    @Test
    @DisplayName("nullable assign Test")
    fun nullableAssignTest() {
        val person = Person("test", null)
        person.company?.addr?.city = "bundang";

        assertThat(person.company).isNull()
        assertThat(person.company?.addr).isNull()
        assertThat(person.company?.addr?.city).isNull()
    }

    @Test
    @DisplayName("nullable assign Test2")
    fun nullableAssignTest2() {
        val address = Address("street", 16384, "test")
        val company = Company("company", address)
        val person = Person("name", company)

        person.company?.addr?.city = "bundang";

        assertThat(person.company).isNotNull
        assertThat(person.company?.addr).isNotNull
        assertThat(person.company?.addr?.city).isEqualTo("bundang")
    }

    @Test
    @DisplayName("nullable test with Null and NullPointerException")
    fun nullableTestWithNullAndNullPointerException() {
        val bitmap: Bitmap? = createBitmap(0, 0)

        // if bitmap is null, throw illegalException
        assertFailsWith(NullPointerException::class) {
            bitmap!!.size
        }
    }

    @Test
    @DisplayName("let test")
    fun letTest() {
        val bitmap: Bitmap? = createBitmap(0, 0)
        val bitmap2: Bitmap? = createBitmap(10, 10)

        // Compile Error
        // drawBitmap(bitmap)

        bitmap?.let {
            drawBitmap(it)
        }

        bitmap2?.let {
            drawBitmap(it)
        }
    }

}