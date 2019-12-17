package com.dongho.dev.lecture.delegate

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test

class DelegateTest {

    @Test
    @DisplayName("Typical Delegate Test")
    fun typicalDelegateTest() {

        class CountingList<E> : MutableList<E> {
            var objectCount: Int = 0

            val innerList: MutableList<E> = arrayListOf()

            override fun add(element: E): Boolean {
                objectCount++
                return innerList.add(element)
            }

            override fun add(index: Int, element: E): Unit {
                objectCount++
                innerList.add(index, element)
            }

            override fun addAll(elements: Collection<E>): Boolean {
                objectCount += elements.size
                return innerList.addAll(elements)
            }

            override fun addAll(index: Int, elements: Collection<E>): Boolean {
                objectCount += elements.size
                return innerList.addAll(index, elements)
            }

            override val size: Int
                get() = innerList.size

            override fun contains(element: E): Boolean = innerList.contains(element)

            override fun containsAll(elements: Collection<E>): Boolean = innerList.containsAll(elements)

            override fun get(index: Int): E = innerList.get(index)

            override fun indexOf(element: E): Int = innerList.indexOf(element)

            override fun isEmpty(): Boolean = innerList.isEmpty()

            override fun iterator(): MutableIterator<E> = innerList.iterator()

            override fun lastIndexOf(element: E): Int = innerList.lastIndexOf(element)

            override fun remove(element: E): Boolean = innerList.remove(element)
            override fun removeAll(elements: Collection<E>): Boolean = innerList.removeAll(elements)
            override fun retainAll(elements: Collection<E>): Boolean = innerList.retainAll(elements)
            override fun clear(): Unit = innerList.clear()

            override fun set(index: Int, element: E): E = innerList.set(index, element)

            override fun removeAt(index: Int): E = innerList.removeAt(index)
            override fun listIterator(): MutableListIterator<E> = innerList.listIterator()
            override fun listIterator(index: Int): MutableListIterator<E> = innerList.listIterator(index)

            override fun subList(fromIndex: Int, toIndex: Int): MutableList<E> = innerList.subList(fromIndex, toIndex)
        }

        val countingList: CountingList<Int> = CountingList()
        countingList.addAll(listOf(1, 2, 3, 4))
        countingList.remove(1)

        assertThat(countingList.objectCount).isEqualTo(countingList.size + 1)
    }

    @Test
    @DisplayName("Delegate Test")
    fun delegateTest() {

        class CountingList<E>(val innerList: ArrayList<E>) : MutableList<E> by innerList {
            var objectCount = 0
            //val innerList: ArrayList<E> = arrayListOf()

            override fun add(element: E): Boolean {
                objectCount++
                return innerList.add(element)
            }

            override fun add(index: Int, element: E): Unit {
                objectCount++
                innerList.add(index, element)
            }

            override fun addAll(elements: Collection<E>): Boolean {
                objectCount += elements.size
                return innerList.addAll(elements)
            }

            override fun addAll(index: Int, elements: Collection<E>): Boolean {
                objectCount += elements.size
                return innerList.addAll(index, elements)
            }
        }

        val countingList: CountingList<Int> = CountingList(arrayListOf())
        countingList.addAll(listOf(1, 2, 3, 4))
        countingList.remove(1)

        assertThat(countingList.objectCount).isEqualTo(countingList.size + 1)
    }

}