package com.dongho.dev.lecture.inheritance

import org.assertj.core.api.Assertions.assertThat
import org.junit.Test
import org.junit.jupiter.api.DisplayName

class ButtonTest {

    @Test
    @DisplayName("Inheritance - (Primary - Primary)")
    fun inheritanceTest() {

        open class Book(val title: String, var price: Int) {
            open fun printInfo() {
                println("Title: $title, Price: $price")
            }
        }

        open class EBook(title: String, price: Int, var url: String): Book(title, price) {
            final override fun printInfo() {
                println("Title: $title, Price: $price, URL: $url")
            }
        }

        val eBook = EBook("ebook", 3000, "https://??")

        assertThat(eBook.title).isEqualTo("ebook")
        assertThat(eBook.price).isEqualTo(3000)
        assertThat(eBook.url).isEqualTo("https://??")
    }

    @Test
    @DisplayName("Inheritance - (No Primary - Primary)")
    fun inheritanceTest2() {

        open class Book {
            val title = "book"
            var price = 2000

            init {
                println("Book2 Init")
            }
        }

        // Book()
        class EBook(val url: String) : Book() {
            fun printInfo() {
                println("Title: $title, Price: $price, URL: $url")
            }
        }

        val eBook = EBook("https://??")

        assertThat(eBook.title).isEqualTo("book")
        assertThat(eBook.price).isEqualTo(2000)
        assertThat(eBook.url).isEqualTo("https://??")
    }


    @Test
    @DisplayName("Inheritance - (No Primary - (No Primary + Secondary)")
    fun inheritanceTest3() {

        open class Book {
            val title = "book"
            var price = 2000

            init {
                println("Book2 Init")
            }
        }

        // Book
        class EBook : Book {
            val url: String

            fun printInfo() {
                println("Title: $title, Price: $price, URL: $url")
            }

            // super()
            constructor(url: String): super() {
                this.url = url
            }
        }

        val eBook = EBook("https://??")

        assertThat(eBook.title).isEqualTo("book")
        assertThat(eBook.price).isEqualTo(2000)
        assertThat(eBook.url).isEqualTo("https://??")
    }

    @Test
    @DisplayName("Inheritance - (No Primary - (Primary + Secondary)")
    fun inheritanceTest4() {

        open class Book {
            val title = "book"
            var price = 2000

            init {
                println("Book2 Init")
            }
        }

        // Book()
        class EBook(val url: String): Book() {
            var esbn: Int = 0

            init {
                println("EBook4 Init")
            }

            fun printInfo() {
                println("Title: $title, Price: $price, URL: $url, ESBN: $esbn")
            }

            // this(url)
            constructor(url: String, esbn: Int): this(url) {
                this.esbn = esbn
            }
        }

        val eBook = EBook("https://??", 1589)

        assertThat(eBook.title).isEqualTo("book")
        assertThat(eBook.price).isEqualTo(2000)
        assertThat(eBook.url).isEqualTo("https://??")
        assertThat(eBook.esbn).isEqualTo(1589)
    }

}