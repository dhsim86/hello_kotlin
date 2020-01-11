package com.dongho.dev.book.kotlin_in_action.class_object_interface.interface_basic

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

interface Clickable {
    fun click(): String
    fun showOff() = "I'm clickable"
}

interface Focusable {
    fun setFocus(b: Boolean) = "I ${if (b) "got" else "lost"} focus."
    fun showOff() = "I'm focusable"
}

class Button: Clickable, Focusable {
    override fun click() = "I was clicked"
    override fun showOff(): String = "I'm button"

    fun clickableShowOff(): String = super<Clickable>.showOff()
    fun focusableShowOff(): String = super<Focusable>.showOff()
}

class InterfaceImplementTest {

    @Test
    @DisplayName("Button click Test")
    fun buttonClickTest() {
        var clickable = Button()

        assertThat(clickable.click()).isEqualTo("I was clicked")
    }

    @Test
    @DisplayName("Multi Implement Test")
    fun multiImplementTest() {
        var button = Button()

        assertThat(button.showOff()).isEqualTo("I'm button")
        assertThat(button.clickableShowOff()).isEqualTo("I'm clickable")
        assertThat(button.focusableShowOff()).isEqualTo("I'm focusable")
    }

}