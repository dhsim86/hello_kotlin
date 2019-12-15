package com.dongho.dev.domain.user

import com.dongho.dev.domin.user.User
import com.dongho.dev.domin.user.UserRepository
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest

@SpringBootTest
class UserRepositoryTest(
    @Autowired val userRepository: UserRepository) {

    @Test
    fun findTest() {
        val userList: List<User> = userRepository.findAll()
        assertThat(userList).isNotEmpty.hasSize(2)
    }

}