package AOCMinaEgna

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayOneAoc2021 {

    @Test
    fun dayOneTestPartOne() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-1-test.txt").readLines().map { it.toInt() }
        println(testInput)
        val listOfIncreases: MutableList<Int> = mutableListOf()
        for (i in 1 until testInput.size) {
            if (testInput[i] > testInput[i - 1]) {
                listOfIncreases.add(testInput[i])
            }
        }
        assertEquals(7,listOfIncreases.size) //7 är det förväntade värdet som anges på AOC hemsida avseende testdatat
    }



    @Test
    fun dayOneActualPartOne() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-1-actual.txt").readLines().map { it.toInt() }
        println(testInput)
        val listOfIncreases: MutableList<Int> = mutableListOf()
        for (i in 1 until testInput.size) {
            if (testInput[i] > testInput[i - 1]) {
                listOfIncreases.add(testInput[i])
            }
        }
        println(listOfIncreases.size)
    }

    @Test
    fun dayOneTestPartTwo() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-1-test.txt").readLines().map { it.toInt() }
        val listOfIncreases: MutableList<Int> = mutableListOf()
        val container: MutableList<Int> = mutableListOf()
        try {
            for (i in testInput.indices) {
                val sum = testInput[i] + testInput[i + 1] + testInput[i + 2]
                container.add(sum)
            }
        } catch (ioobe: IndexOutOfBoundsException) {
            for (i in 1 until container.size) {
                if (container[i] > container[i - 1]) {
                    listOfIncreases.add(container[i])
                }
            }
            assertEquals(5, listOfIncreases.size) // 5 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        }
    }

    @Test
    fun dayOneActualPartTwo() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-1-actual.txt").readLines().map { it.toInt() }
        val listOfIncreases: MutableList<Int> = mutableListOf()
        val container: MutableList<Int> = mutableListOf()
        try {
            for (i in testInput.indices) {
                val sum = testInput[i] + testInput[i + 1] + testInput[i + 2]
                container.add(sum)
            }
        } catch (ioobe: IndexOutOfBoundsException) {
            for (i in 1 until container.size) {
                if (container[i] > container[i - 1]) {
                    listOfIncreases.add(container[i])
                }
            }
            println(listOfIncreases.size)
        }
    }
}