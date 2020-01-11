package com.dongho.dev.book.kotlin_in_action.class_object_interface.inner_class;

import org.jetbrains.annotations.NotNull;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ButtonJava implements View {

    class ButtonState implements State {

        private String data;

        public ButtonState(String data) {
            this.data = data;
        }

        public String getName() {
            return name;
        }

    }

    private ButtonState state;
    private String name;

    public ButtonJava(String name) {
        this.name = name;
    }

    @NotNull
    @Override
    public ButtonState getCurrentState() {
        return state;
    }

    @Override
    public void restoreState(@NotNull State state) {
        if (state instanceof ButtonState) {
            this.state = ButtonState.class.cast(state);
        }
    }

    public String getData() {
        return state.data;
    }
}

public class InnerClassTestJava {

    @Test
    @DisplayName("Inner Class Access Test")
    public void innerClassAccessTest() {
        ButtonJava button = new ButtonJava("buttonTest");
        button.restoreState(button.new ButtonState("buttonData"));

        assertThat(button.getData()).isEqualTo("buttonData");
        assertThat(button.getCurrentState().getName()).isEqualTo("buttonTest");
    }

}
