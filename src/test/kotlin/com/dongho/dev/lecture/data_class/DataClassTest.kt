package com.dongho.dev.lecture.data_class

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DataClassTest {

    @Test
    @DisplayName("data class - toString test")
    fun classToStringTest() {
        class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)
        println(client)

        // com.dongho.dev.lecture.data_class.DataClassTest$classToStringTest$Client@609cd4d8
    }

    @Test
    @DisplayName("data class - toString test")
    fun dataClassToStringTest() {
        data class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)
        println(client)

        // Client(name=test, postalCode=1234)
    }

    @Test
    @DisplayName("class - equals test")
    fun classEqualsTest() {
        class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)
        val client1 = Client("test", 1234)

        assertThat(client === client1).isFalse()
        assertThat(client == client1).isFalse()
        assertThat(client.equals(client1)).isFalse()
    }

    @Test
    @DisplayName("class - equals test with override")
    fun classEqualsOverrideTest() {
        class Client(val name: String, val postalCode: Int) {
            override fun equals(other: Any?): Boolean {
                if (other == null || other !is Client) {
                    return false
                }
                // !is <- smart cast
                return name == other.name && postalCode == other.postalCode
            }
        }

        val client = Client("test", 1234)
        val client1 = Client("test", 1234)

        assertThat(client === client1).isFalse()
        assertThat(client == client1).isTrue()
        assertThat(client.equals(client1)).isTrue()
    }

    @Test
    @DisplayName("data class - equals test")
    fun dataClassEqualsTest() {
        data class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)
        val client1 = Client("test", 1234)

        assertThat(client === client1).isFalse()
        assertThat(client == client1).isTrue()
        assertThat(client.equals(client1)).isTrue()
    }

    @Test
    @DisplayName("class - hashCode test")
    fun classHashCodeTest() {
        class Client(val name: String, val postalCode: Int) {
            override fun equals(other: Any?): Boolean {
                if (other == null || other !is Client) {
                    return false
                }
                // !is <- smart cast
                return name == other.name && postalCode == other.postalCode
            }
        }

        val client = Client("test", 1234)

        val clientSetWithOtherObject = hashSetOf(Client("test", 1234))
        assertThat(clientSetWithOtherObject.contains(client)).isFalse()

        val clientSetWithReferObject = hashSetOf(client)
        assertThat(clientSetWithReferObject.contains(client)).isTrue()
    }

    @Test
    @DisplayName("class - hashCode test with override")
    fun classHashCodeOverrideTest() {
        class Client(val name: String, val postalCode: Int) {
            override fun equals(other: Any?): Boolean {
                if (other == null || other !is Client) {
                    return false
                }
                // !is <- smart cast
                return name == other.name && postalCode == other.postalCode
            }

            override fun hashCode() = name.hashCode() * 31 + postalCode
        }

        val client = Client("test", 1234)

        val clientSetWithOtherObject = hashSetOf(Client("test", 1234))
        assertThat(clientSetWithOtherObject.contains(client)).isTrue()

        val clientSetWithReferObject = hashSetOf(client)
        assertThat(clientSetWithReferObject.contains(client)).isTrue()
    }

    @Test
    @DisplayName("data class - hashCode test")
    fun dataClassHashCodeTest() {
        data class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)

        val clientSetWithOtherObject = hashSetOf(Client("test", 1234))
        assertThat(clientSetWithOtherObject.contains(client)).isTrue()

        val clientSetWithReferObject = hashSetOf(client)
        assertThat(clientSetWithReferObject.contains(client)).isTrue()
    }

    @Test
    @DisplayName("data class - copy test")
    fun dataClassCopyTest() {
        data class Client(val name: String, val postalCode: Int)

        val client = Client("test", 1234)
        val client2 = client.copy(name = "test2")

        assertThat(client !== client2).isTrue()
        assertThat(client != client2).isTrue()
        assertThat(client.name).isNotEqualTo(client2.name)
        assertThat(client.postalCode).isEqualTo(client2.postalCode)
    }

    @Test
    @DisplayName("data class - primary constructor property Test")
    fun dataClassPrimaryConstructorPropertyTest() {
        data class Client(val name: String, val postalCode: Int) {
            var number: Int = 0

            constructor(name: String, postalCode: Int, number: Int): this(name, postalCode) {
                this.number = number
            }
        }

        val client = Client("test", 1234, 1)
        val client2 = Client("test", 1234, 2)

        assertThat(client !== client2).isTrue()

        assertThat(client == client2).isTrue()
        assertThat(client.name == client2.name).isTrue()
        assertThat(client.postalCode == client2.postalCode).isTrue()
        assertThat(client.number != client2.number).isTrue()
    }

}