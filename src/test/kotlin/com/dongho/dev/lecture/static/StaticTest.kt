package com.dongho.dev.lecture.static

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class Bar

class Foo {

    companion object {

        const val static_var = "bar"

        //For java
        @JvmField val bar = Bar()

        //For java
        @JvmStatic fun static_func(): String {
            return static_var
        }
    }
}

class StaticTest {

    @Test
    @DisplayName("Static Test")
    fun staticTest() {
        assertThat(Foo.static_var).isEqualTo("bar")
        assertThat(Foo.static_func()).isEqualTo("bar")
    }

}