package com.dongho.dev.lecture.inheritance

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

open class Human(val name: String, var age: Int) {
    var country: String = ""

    init {
        println("Human Init")
    }

    // this(name, age)
    constructor(name: String, age: Int, country: String): this(name, age) {
        this.country = country
    }

    open fun printInfo() {
        println("name: ${name}, age: ${age}, country: ${country}")
    }
}

// Human(name, age, country)
class Student(name: String, age: Int, country: String, var school: String) : Human(name, age, country) {
    var classNumber: Int = 1

    init {
        println("Student Test")
    }

    // this(name, age, country, school)
    constructor(name: String, age: Int, country: String, school: String, classNumber: Int) : this(name, age, country, school) {
        this.classNumber = classNumber
    }

    final override fun printInfo() {
        println("name: ${name}, age: ${age}, country: ${country}, school: ${school}, classNumber: ${classNumber}")
    }
}

class HumanStudentTest {

    @Test
    fun humanTest() {
        val human1 = Human("name", 1)
        val human2 = Human("name2", 2, "Korea")

        """
        Human Init
        Human Init
        """

        assertThat(human1.name).isEqualTo("name")
        assertThat(human1.age).isEqualTo(1)
        assertThat(human1.country).isEqualTo("")

        assertThat(human2.name).isEqualTo("name2")
        assertThat(human2.age).isEqualTo(2)
        assertThat(human2.country).isEqualTo("Korea")
    }

    @Test
    fun studentTest() {
        val student1 = Student("name", 1, "Korea", "School0")
        val student2 = Student("name2", 2, "Korea", "School1", 10)

        """
        Human Init
        Student Test
        Human Init
        Student Test
        """

        assertThat(student1.name).isEqualTo("name")
        assertThat(student1.age).isEqualTo(1)
        assertThat(student1.country).isEqualTo("Korea")
        assertThat(student1.school).isEqualTo("School0")
        assertThat(student1.classNumber).isEqualTo(1)

        assertThat(student2.name).isEqualTo("name2")
        assertThat(student2.age).isEqualTo(2)
        assertThat(student2.country).isEqualTo("Korea")
        assertThat(student2.school).isEqualTo("School1")
        assertThat(student2.classNumber).isEqualTo(10)
    }
}