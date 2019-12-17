package com.dongho.dev.lecture.delegate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test


class LazyPropertyTest {

    @Test
    @DisplayName("typical lazy init property Test")
    fun typicalLazyInitPropertyTest() {

        data class Address(val name: String, var phone: String, var address: String = "")

        class Person(val name: String) {
            private var _addressList: List<Address>? = null

            val addressList: List<Address>
                get() {
                    if (_addressList == null) {
                        _addressList = loadAddress(this)
                    }
                    return _addressList!!
                }

            fun loadAddress(p: Person): List<Address> {
                println("Load ${p.name}'s information...")
                return listOf(Address("addr1", "010", "city1"),
                        Address("addr2", "011", "city2"))
            }
        }

        val p = Person("name")

        """
        before load address
        Load name's information...
        """
        println("before load address")
        assertThat(p.addressList).isNotEmpty.hasSize(2)
    }

    @Test
    @DisplayName("lazy init property Test")
    fun lazyInitPropertyTest() {

        data class Address(val name: String, var phone: String, var address: String = "")

        class Person(val name: String) {
            val addressList by lazy { loadAddress(this) }

            fun loadAddress(p: Person): List<Address> {
                println("Load ${p.name}'s information...")
                return listOf(Address("addr1", "010", "city1"),
                        Address("addr2", "011", "city2"))
            }
        }

        val p = Person("name")

        """
        before load address
        Load name's information...
        """
        println("before load address")
        assertThat(p.addressList).isNotEmpty.hasSize(2)
    }
}