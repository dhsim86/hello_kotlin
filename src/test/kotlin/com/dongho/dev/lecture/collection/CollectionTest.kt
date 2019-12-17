package com.dongho.dev.lecture.collection

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import java.util.*
import kotlin.collections.ArrayList
import kotlin.collections.LinkedHashMap

class CollectionTest {

    @Test
    @DisplayName("List Test")
    fun listTest() {
        val list: List<Int> = List(5) { i -> i }

        assertThat(list).isNotEmpty.hasSize(5)
        assertThat(list).containsExactly(0, 1, 2, 3, 4)

        val list2: List<Int> = listOf(0, 1, 2, 3, 4)
        assertThat(list2).isNotEmpty.hasSize(5)
        assertThat(list2).containsExactly(0, 1, 2, 3, 4)
    }

    @Test
    @DisplayName("Mutable List Test")
    fun mutableListTest() {
        val array: MutableList<Int> = MutableList(5) { i -> i }
        array[0] = 10
        array.add(20)

        assertThat(array).isNotEmpty.hasSize(6)
        assertThat(array).containsExactly(10, 1, 2, 3, 4, 20)

        val array2: MutableList<Int> = mutableListOf(0, 1, 2, 3, 4)
        array2[0] = 10
        array2.add(20)

        assertThat(array2).isNotEmpty.hasSize(6)
        assertThat(array2).containsExactly(10, 1, 2, 3, 4, 20)
    }

    @Test
    @DisplayName("Array List Test")
    fun arrayListTest() {
        val array: ArrayList<Int> = ArrayList()
        array.add(10)
        array.add(20)

        assertThat(array).isNotEmpty.hasSize(2)
        assertThat(array).containsExactly(10, 20)

        val array2: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4)
        array2[0] = 10
        array2.add(20)

        assertThat(array2).isNotEmpty.hasSize(6)
        assertThat(array2).containsExactly(10, 1, 2, 3, 4, 20)
    }

    @Test
    @DisplayName("Set Test")
    fun setTest() {
        val set: Set<Int> = setOf(1, 2, 3, 3)

        assertThat(set).isNotEmpty.hasSize(3)
        assertThat(set).containsExactly(1, 2, 3)
    }

    @Test
    @DisplayName("Mutable Set Test")
    fun mutableSetTest() {
        //val set: TreeSet<Int> = sortedSetOf(1, 2, 3, 3)
        //val set: LinkedHashSet<Int> = linkedSetOf(1, 2, 3, 3)
        //val set: HashSet<Int> = hashSetOf(1, 2, 3, 3)
        val set: MutableSet<Int> = mutableSetOf(1, 2, 3, 3)

        assertThat(set).isNotEmpty.hasSize(3)
        assertThat(set).containsExactly(1, 2, 3)

        set.add(3)
        set.add(4)

        assertThat(set).isNotEmpty.hasSize(4)
        assertThat(set).containsExactly(1, 2, 3, 4)
    }

    @Test
    @DisplayName("Map Test")
    fun mapTest() {
        val map: Map<Int, String> = mapOf(1 to "1", 2 to "2", 3 to "3")

        assertThat(map).hasSize(3)
        assertThat(map).containsKeys(1, 2, 3)
        assertThat(map).containsValues("1", "2", "3")
        assertThat(map).containsExactlyEntriesOf(mapOf(1 to "1", 2 to "2", 3 to "3"))
    }

    @Test
    @DisplayName("Mutable Map Test")
    fun mutableMapTest() {
        //val map: SortedMap<Int, String> = sortedMapOf(1 to "1", 2 to "2", 3 to "3")
        //val map: LinkedHashMap<Int, String> = linkedMapOf(1 to "1", 2 to "2", 3 to "3")
        //val map: HashMap<Int, String> = hashMapOf(1 to "1", 2 to "2", 3 to "3")
        val map: MutableMap<Int, String> = mutableMapOf(1 to "1", 2 to "2", 3 to "3")

        map.put(4, "4")
        map.remove(1)

        assertThat(map).hasSize(3)
        assertThat(map).containsKeys(2, 3, 4)
        assertThat(map).containsValues("2", "3", "4")
        assertThat(map).containsExactlyEntriesOf(mapOf(2 to "2", 3 to "3", 4 to "4"))
    }

}