package com.dongho.dev.book.kotlin_in_action.function.collection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.DisplayName;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class JavaCaller {

    @Test
    @DisplayName("joinToString Test in Java")
    public void joinToStringTest() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        assertThat(test.joinToString(list, ", ")).isEqualTo("1, 2, 3");
        assertThat(test.joinToString(list, ", ", "(", ")")).isEqualTo("(1, 2, 3)");
        assertThat(test.joinToString(list, "; ", "(", ")" )).isEqualTo("(1; 2; 3)");
    }

    @Test
    @DisplayName("joinToString2 Test in Java")
    public void joinToString2Test() {
        List<Integer> list = Arrays.asList(1, 2, 3);

        assertThat(test.joinToString2(list, ", ")).isEqualTo("1, 2, 3");
        assertThat(test.joinToString2(list, ", ", "(", ")")).isEqualTo("(1, 2, 3)");
        assertThat(test.joinToString2(list, "; ", "(", ")" )).isEqualTo("(1; 2; 3)");
    }

}
