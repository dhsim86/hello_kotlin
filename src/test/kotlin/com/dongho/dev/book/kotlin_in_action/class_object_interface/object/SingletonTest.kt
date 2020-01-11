package com.dongho.dev.book.kotlin_in_action.class_object_interface.`object`

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

data class Person(val name: String, val salary: Int)

object Payroll {

    val allEmployees = arrayListOf<Person>()

    fun addEmployee(person: Person) {
        allEmployees.add(person)
    }

    fun calculateSalary(): Int {
        var salary = 0

        for (employee in allEmployees) {
            salary += employee.salary
        }

        return salary
    }

}

class SingletonTest {

    @Test
    @DisplayName("Singleton Test")
    fun singletonTest() {

        val personList = listOf(Person("name1", 1000), Person("name2", 2000))

        for (person in personList) {
            Payroll.addEmployee(person)
        }

        assertThat(Payroll.calculateSalary()).isEqualTo(3000)
    }

}