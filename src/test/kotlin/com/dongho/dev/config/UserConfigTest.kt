package com.dongho.dev.config

import com.dongho.dev.domin.user.UserService
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserConfigTest(
    @Autowired val userService: UserService) {

    @Test
    fun configTest() {
        assertThat(userService).isNotNull
    }

}