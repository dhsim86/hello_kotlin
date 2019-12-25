package com.dongho.dev.book.kotlin_in_action.function.extension_property;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaCaller {

    @Test
    @DisplayName("extensionPropertyTest in Java")
    public void extensionPropertyTest() {
        StringBuilder builder = new StringBuilder("Hello Java?");

        ExtensionProperty.setLastChar(builder,'!');
        assertThat(builder.toString()).isEqualTo("Hello Java!");
    }

}
