package com.dongho.dev.lecture.delegate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import kotlin.properties.Delegates
import kotlin.reflect.KProperty

class DelegatePropertyTest {

    @Test
    @DisplayName("getter setter Test")
    fun getterSetterTest() {

        class Person(val name: String, _age: Int, _salary: Int) {
            var age: Int = _age
            get() {
                println("age get! ${field}")
                return field
            }
            set(value) {
                println("age set! ${value}")
                field = value
            }

            var salary: Int = _salary
            get() {
                println("salary get! ${field}")
                return field
            }
            set(value) {
                println("salary set! ${value}")
                field = value
            }
        }
        """
        age set! 21
        salary set! 2100
        age get! 21
        salary get! 2100
        name - age: 21, salary: 2100
        """
        val p = Person("name", 20, 2000)
        p.age = 21
        p.salary = 2100

        println("${p.name} - age: ${p.age}, salary: ${p.salary}")
    }

    @Test
    @DisplayName("getter setter delegate Test")
    fun getterSetterDelegateTest() {

        class Delegator(val fname: String) {
            var value: Int = 0

            fun getMethod(): Int {
                println("$fname get! $value")
                return value
            }

            fun setMethod(newValue: Int) {
                println("$fname set! $newValue")
                value = newValue
            }
        }

        class Person(val name: String) {
            val ageDelegator = Delegator("age")
            val salaryDelegator = Delegator("salary")

            var age: Int
            get() = ageDelegator.getMethod()
            set(value) = ageDelegator.setMethod(value)

            var salary: Int
            get() = salaryDelegator.getMethod()
            set(value) = salaryDelegator.setMethod(value)
        }

        """
        age set! 21
        salary set! 2100
        age get! 21
        salary get! 2100
        name - age: 21, salary: 2100
        """
        val p = Person("name")
        p.age = 21
        p.salary = 2100

        println("${p.name} - age: ${p.age}, salary: ${p.salary}")
    }

    @Test
    @DisplayName("getter setter delegate by Test")
    fun getterSetterDelegateByTest() {

        class Delegator(var value: Int) {
            operator fun getValue(thisRef: Any?, property: KProperty<*>): Int {
                println("${property.name} get! $value")
                return value
            }

            operator fun setValue(thisRef: Any?, property: KProperty<*>, newValue: Int) {
                println("${property.name} set! $newValue")
                value = newValue
            }
        }

        class Person(val name: String, _age: Int, _salary: Int) {
            var age: Int by Delegator(_age)
            var salary: Int by Delegator(_salary)
        }

        """
        age set! 21
        salary set! 2100
        age get! 21
        salary get! 2100
        name - age: 21, salary: 2100
        """
        val p = Person("name", 20, 2000)
        p.age = 21
        p.salary = 2100

        println("${p.name} - age: ${p.age}, salary: ${p.salary}")
    }

    @Test
    @DisplayName("setter delegate by test with observable")
    fun setterDelegateByObservableTest() {

        class Person(val name: String, _age: Int, _salary: Int) {
            var age: Int by Delegates.observable(_age) {
                prop, old, new -> println("${prop.name} set! $old -> $new")
            }
            var salary: Int by Delegates.observable(_salary) {
                prop, old, new -> println("${prop.name} set! $old -> $new")
            }
        }

        """
        age set! 20 -> 21
        salary set! 2000 -> 2100
        name - age: 21, salary: 2100
        """
        val p = Person("name", 20, 2000)
        p.age = 21
        p.salary = 2100

        println("${p.name} - age: ${p.age}, salary: ${p.salary}")
    }

    @Test
    @DisplayName("setter getter delegate using map")
    fun setterGetterDelegateUsingMapTest() {

        class Person(val map: MutableMap<String, Any>) {
            var name: String by map
            var age: Int by map
            var salary: Int by map
        }

        val p = Person(mutableMapOf())
        p.name = "test"
        p.age = 20
        p.salary = 2000

        assertThat(p.map).hasSize(3).containsExactlyEntriesOf(mapOf("name" to "test", "age" to 20, "salary" to 2000))
    }

}