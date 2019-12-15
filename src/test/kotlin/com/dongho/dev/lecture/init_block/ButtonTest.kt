package com.dongho.dev.lecture.init_block

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class ButtonTest {

    @Test
    @DisplayName("Button - init block")
    fun initBlockTest() {

        // init block will be called after primary constructor, before secondary constructor.
        // init block order is same with definition order.
        class Button(var id: Int) {
            var text: String = ""

            init {
                println("Init block: $id, $text")
            }

            init {
                println("Init block2: $id, $text")
            }

            constructor(id: Int, text: String): this(id) {
                this.text = text
                println("constructor(id, text): ${this.id}, ${this.text}")
            }
        }

        val button: Button = Button(3, "test")

        """
        Init block: 3,
        Init block2: 3,
        constructor(id, text): 3, test
        """

        assertThat(button.id).isEqualTo(3)
        assertThat(button.text).isEqualTo("test")
    }

}