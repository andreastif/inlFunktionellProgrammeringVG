import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

open class DayOneAoc2019 {

    @Test
    fun dayOneTestPartOne() {
        //MIN EGNA
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1/day-1-test.txt").readLines() as MutableList<String>
        println(myList)
        assertEquals(3, myList.size)
        fun findFuel(mass: Int) = (mass / 3) - 2
        assertEquals(2, findFuel(myList[0].toInt()))
        assertEquals(654, findFuel(myList[1].toInt()))
        assertEquals(33583, findFuel(myList[2].toInt()))

        //LÖSNING FRÅN NÄTET <REF>

    }

    @Test
    fun dayOneActualPartOne() {
        //MIN EGNA
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1/day-1-actual.txt").readLines() as MutableList<String>

        fun findFuel(mass: Int) = (mass / 3) - 2
        val totalFuel = myList.sumOf { e -> findFuel(e.toInt()) }
        assertEquals(3386686, totalFuel)

        //LÖSNING FRÅN NÄTET <REF>
    }

    @Test
    fun dayOneTestPartTwo() {
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1/day-1-test.txt").readLines() as MutableList<String>
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
        assertEquals(966, findFuel(myList[1].toInt()))
        assertEquals(50346, findFuel(myList[2].toInt()))
    }

    @Test
    fun dayOneActualPartTwo() {
        val myList: MutableList<String> =
            File("src/main/kotlin/HuvudprogramVGDEL1/day-1-actual.txt").readLines() as MutableList<String>
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

        val totalFuel = myList.sumOf { e -> findFuel(e.toInt()) }
        println(totalFuel)
        assertEquals(5077155, totalFuel )

        //LÖSNING FRÅN NÄTET <REF>

    }

}