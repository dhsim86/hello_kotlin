package com.dongho.dev.lecture.`interface`

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName

interface User {
    val nickName: String   // abstract Property

    fun printNickName() = println(nickName)
}

class UserTest {

    @Test
    @DisplayName("abstract Property Test")
    fun abstractPropertyTest() {

        class PrivateUser(override val nickName: String) : User {

        }

        class SubScribeUser(val email: String): User {
            override val nickName: String = getId()

            fun getId() = email.substringBefore('@')
        }

        val user = PrivateUser("test")
        val user2 = SubScribeUser("nickTest@test.com")

        assertThat(user.nickName).isEqualTo("test")
        assertThat(user2.nickName).isEqualTo("nickTest")

        """
        test
        nickTest
        """

        user.printNickName()
        user2.printNickName()
    }

}