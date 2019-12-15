package com.dongho.dev.lecture.`class`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ButtonTest {

    @Test
    @DisplayName("Button - No Constructors")
    fun buttonTest0() {

        class Button {
            var id: Int = 0
        }

        val button = Button()
        assertThat(button.id).isEqualTo(0)
    }

    @Test
    @DisplayName("Button - Primary Constructor")
    fun buttonTest1() {

        class Button(_id: Int) {
            val id: Int = _id
        }

        val button = Button(10)
        assertThat(button.id).isEqualTo(10)
    }

    @Test
    @DisplayName("Button - Primary Constructor 2")
    fun buttonTest2() {

        class Button(val id: Int)

        val button = Button(10)
        assertThat(button.id).isEqualTo(10)
    }

    @Test
    @DisplayName("Button - Primary Constructor 2")
    fun buttonTest3() {

        // _id Is Not Field of Button
        class Button(_id: Int, val id: Int)

        val button = Button(5, 10)
        assertThat(button.id).isEqualTo(10)
    }

    @Test
    @DisplayName("Button - Primary Constructor 2")
    fun buttonTest4() {

        // _displayName is Not Field of Button
        class Button(val id: Int, val name: String, _displayName: String) {
            val displayName: String = _displayName
        }

        val button = Button(5, "button", "Click Me")
        assertThat(button.id).isEqualTo(5)
        assertThat(button.name).isEqualTo("button")
        assertThat(button.displayName).isEqualTo("Click Me")
    }

}