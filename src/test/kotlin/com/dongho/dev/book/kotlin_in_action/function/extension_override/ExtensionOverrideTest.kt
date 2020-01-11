package com.dongho.dev.book.kotlin_in_action.function.extension_override

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

open class View {
    open fun click() = "View Clicked"
}

class Button: View() {
    override fun click() = "Button Clicked"
}

fun View.showOff() = "I'm View!"
fun Button.showOff() = "I'm Button!"

class ExtensionOverrideTest {

    @Test
    @DisplayName("extension override Test")
    fun extensionOverrideTest() {
        val view: View = Button()   // View type
        val button = Button()       // Button type

        assertThat(view.click()).isEqualTo("Button Clicked")
        assertThat(view.showOff()).isEqualTo("I'm View!")

        assertThat(button.click()).isEqualTo("Button Clicked")
        assertThat(button.showOff()).isEqualTo("I'm Button!")
    }


}