package com.dongho.dev.lecture.operator_overloading

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class OperatorOverloadingTest {

    @Test
    @DisplayName("+ overloading Test")
    fun plusOverloadingTest() {
        data class Point(var x: Int, var y: Int) {
            // + binary
            operator fun plus(other: Point) : Point {
                return Point(x + other.x, y + other.y)
            }

            operator fun plus(delta: Int): Point {
                return Point(x + delta, y + delta)
            }

            // - unary
            operator fun unaryMinus() = Point(-x, -y)

            operator fun inc() = Point(x + 1, y + 1)
            operator fun dec() = Point(x - 1, y - 1)

            // +=
            operator fun plusAssign(other: Point) {
                x += other.x
                y += other.y
            }
        }

        var p1 = Point(10, 20)
        var p2 = Point(30, 40)

        val p3 = p1 + p2
        assertThat(p3.x).isEqualTo(40)
        assertThat(p3.y).isEqualTo(60)

        val p4 = p1 + 1
        assertThat(p4.x).isEqualTo(11)
        assertThat(p4.y).isEqualTo(21)

        val p5 = -p1
        assertThat(p5.x).isEqualTo(-p1.x)
        assertThat(p5.y).isEqualTo(-p1.y)

        // p1 is var
        val p6 = p1++
        assertThat(p6.x).isEqualTo(p1.x - 1)
        assertThat(p6.y).isEqualTo(p1.y - 1)
    }

}