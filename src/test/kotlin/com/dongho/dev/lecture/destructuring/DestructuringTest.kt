package com.dongho.dev.lecture.destructuring

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DestructuringTest {

    @Test
    @DisplayName("Destructuring Test")
    fun destructuringTest() {
        class Person(val name: String, val age: Int) {
            operator fun component1() = name
            operator fun component2() = age
        }
        val person = Person("test", 20)

        val (name, age) = person
        assertThat(name).isEqualTo(person.name)
        assertThat(age).isEqualTo(person.age)
    }

    @Test
    @DisplayName("Destructuring For Test")
    fun destructuringForTest() {
        class Person(val name: String, val age: Int) {
            operator fun component1() = name
            operator fun component2() = age
        }

        val personList = listOf(Person("test0", 20), Person("test1", 21))

        //name: test0, age: 20
        //name: test1, age: 21
        for ((name, age) in personList) {
            println("name: ${name}, age: ${age}")
        }
    }

    @Test
    @DisplayName("Data Class Destructuring For Test")
    fun dataClassDestructuringForTest() {
        data class Person(val name: String, val age: Int)
        val person = Person("test", 20)

        val (name, age) = person
        assertThat(name).isEqualTo(person.name)
        assertThat(age).isEqualTo(person.age)
    }

    @Test
    @DisplayName("Data Class Destructuring For Test with Return")
    fun dataClassDestructuringForTestWithReturn() {
        data class Person(val name: String, val age: Int)

        fun create(name: String, age: Int) = Person(name, age)

        val (name, age) = create("test", 20)
        assertThat(name).isEqualTo("test")
        assertThat(age).isEqualTo(20)
    }

}