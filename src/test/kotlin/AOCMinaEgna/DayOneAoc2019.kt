package AOCMinaEgna

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

open class DayOneAoc2019 {

    @Test
    fun dayOneTestPartOne() {

        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-1-test.txt").readLines() as MutableList<String>

        assertEquals(3, myList.size)
        fun findFuel(mass: Int) = (mass / 3) - 2

        assertEquals(2, findFuel(myList[0].toInt())) //2 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        assertEquals(654, findFuel(myList[1].toInt())) //654 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        assertEquals(33583, findFuel(myList[2].toInt())) //33583 är det förväntade värdet som anges på AOC hemsida avseende testdatat

    }

    @Test
    fun dayOneActualPartOne() {
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-1-actual.txt").readLines() as MutableList<String>

        fun findFuel(mass: Int) = (mass / 3) - 2
        val totalFuel = myList.sumOf { e -> findFuel(e.toInt()) }
        println(totalFuel)

    }

    @Test
    fun dayOneTestPartTwo() {
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-1-test.txt").readLines() as MutableList<String>
        //MIN EGNA
        fun findFuel(mass: Int): Int {
            fun totalFuelNeeded(fuel: Int, acc: Int): Int {
                val x = (fuel / 3) - 2
                return if (x > 0) {
                    totalFuelNeeded(x, acc + x)
                } else
                    acc
            }
            return totalFuelNeeded(mass, 0)
        }
        assertEquals(966, findFuel(myList[1].toInt())) //966 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        assertEquals(50346, findFuel(myList[2].toInt())) //50346 är det förväntade värdet som anges på AOC hemsida avseende testdatat
    }

    @Test
    fun dayOneActualPartTwo() {
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-1-actual.txt").readLines() as MutableList<String>

        fun findFuel(mass: Int): Int {
            fun totalFuelNeeded(fuel: Int, acc: Int): Int {
                val x = (fuel / 3) - 2
                return if (x > 0) {
                    totalFuelNeeded(x, acc + x)
                } else
                    acc
            }
            return totalFuelNeeded(mass, 0)
        }

        val totalFuel = myList.sumOf { e -> findFuel(e.toInt()) }
        println(totalFuel)

    }

}