package com.dongho.dev.lecture.`interface`

import org.junit.Test
import org.junit.jupiter.api.DisplayName

interface Clickable {
    fun click()
    fun showOff() = println("click off")  // like to default method of Java
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("focus off")
}

class ButtonTest {

    @Test
    @DisplayName("Interface Test")
    fun interfaceTest() {

        class Button : Clickable {
            override fun click() = println("clicked")
        }

        val button = Button()
        button.click()
        button.showOff()
    }

    @Test
    @DisplayName("Interface Duplicate Test, showOff override")
    fun interfaceTest2() {

        class Button : Clickable, Focusable {

            override fun click() = println("clicked")
            override fun showOff() = println("must be overrided")

            fun callAllShowOff() {
                super<Clickable>.showOff()
                super<Focusable>.showOff()
            }
        }

        val button = Button()
        button.click()
        button.setFocus(true)
        button.showOff()
        button.setFocus(false)

        button.callAllShowOff()
    }

}