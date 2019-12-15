package com.dongho.dev.lecture.getter_setter

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.DisplayName

class RectangleTest {

    @Test
    @DisplayName("Basic Getter And Setter Test")
    fun getAndSetterTest() {

        class Rectangle {
            val isSquare: Boolean
            get() = height == width

            var height: Int = 0
            get() = field
            set(value) {
                println("height setter")
                field = value
            }

            var width: Int = 0
            get() = field
            set(value) {
                println("width setter")
                field = value
            }
/*
            init {
                isSquare = if (height == width) true else false
            }
 */

            var name: String = ""
            private set
        }

        val rect = Rectangle()
        rect.height = 20
        rect.width = 30

        println("height: ${rect.height}, width: ${rect.width}")
        println("isSquare: ${rect.isSquare}")

        """
            height setter
            width setter
            height: 20, width: 30
            false
        """

        rect.height = 30
        println("height: ${rect.height}, width: ${rect.width}")
        println("isSquare: ${rect.isSquare}")

        """
            height setter
            height: 30, width: 30
            true
        """
    }

}