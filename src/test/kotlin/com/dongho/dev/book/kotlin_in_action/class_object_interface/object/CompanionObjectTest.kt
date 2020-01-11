package com.dongho.dev.book.kotlin_in_action.class_object_interface.`object`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class User {

    val nickname: String

    constructor(email: String) {
        nickname = email.substringAfterLast('@')
    }

    constructor(accountId: Int) {
        nickname = calculateAccountId(accountId)
    }

    private fun calculateAccountId(id: Int) = Integer.toHexString(id)

}

class UserWithFactory private constructor(val nickname: String) {

    companion object {

        fun newInstance(email: String) = UserWithFactory(email.substringBefore('@'))
        fun newInstance(accountId: Int) = UserWithFactory(Integer.toHexString(accountId))
    }

}

class CompanionObjectTest {

    @Test
    @DisplayName("factory method with companion object Test")
    fun factoryMethodTest() {

        val user1 = UserWithFactory.newInstance("test@gmail.com")
        val user2 = UserWithFactory.newInstance(15)

        assertThat(user1.nickname).isEqualTo("test")
        assertThat(user2.nickname).isEqualTo(Integer.toHexString(15))
    }

}