package com.dongho.dev.book.kotlin_in_action.class_object_interface.inner_class

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.io.Serializable

interface State: Serializable

interface View {
    fun getCurrentState(): State?
    fun restoreState(state: State)
}

class Button(val name: String): View {

    inner class ButtonState(val data: String): State {
        fun getName() = name
    }

    var state: ButtonState? = null

    override fun getCurrentState() = state
    override fun restoreState(state: State) {
        this.state = if (state is ButtonState) state else null
    }

    fun getData(): String = state?.data ?: ""

}

class InnerClassTest {

    @Test
    @DisplayName("Inner Class Access Test")
    fun innerClassAccessTest() {
        val button = Button("buttonTest")
        button.restoreState(button.ButtonState("buttonData"))

        assertThat(button.getData()).isEqualTo("buttonData")
        assertThat(button.getCurrentState()?.getName() ?: "").isEqualTo("buttonTest")
    }


}