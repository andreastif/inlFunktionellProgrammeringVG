package AOCMinaEgna

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayTwoAoc2021 {

    @Test
    fun dayTwoTestPartOne() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-2-test.txt").readLines()
        assertEquals(6, testInput.size)

        fun traverseCourse(): Int {
            val horizontal = mutableListOf<Int>()
            val depthDown = mutableListOf<Int>()
            val depthUp = mutableListOf<Int>()

            for (i in 0 until testInput.size) {
                if (testInput[i].contains("forward")) {
                    horizontal.add(testInput[i].substring(testInput[i].length - 1).toInt())
                } else if (testInput[i].contains("down")) {
                    depthDown.add(testInput[i].substring(testInput[i].length - 1).toInt())
                } else {
                    depthUp.add(testInput[i].substring(testInput[i].length - 1).toInt())
                }
            }

            return horizontal.sum() * (depthDown.sum() - depthUp.sum())
        }
        assertEquals(150, traverseCourse()) //150 är det förväntade värdet som anges på AOC hemsida avseende testdatat

    }

    @Test
    fun dayTwoActualPartOne() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-2-actual.txt").readLines()

        fun traverseCourse(): Int {
            val horizontal = mutableListOf<Int>()
            val depthDown = mutableListOf<Int>()
            val depthUp = mutableListOf<Int>()

            for (i in 0 until testInput.size) {
                if (testInput[i].contains("forward")) {
                    horizontal.add(testInput[i].substring(testInput[i].length - 1).toInt())
                } else if (testInput[i].contains("down")) {
                    depthDown.add(testInput[i].substring(testInput[i].length - 1).toInt())
                } else {
                    depthUp.add(testInput[i].substring(testInput[i].length - 1).toInt())
                }
            }
            return horizontal.sum() * (depthDown.sum() - depthUp.sum())
        }
        println(traverseCourse())

    }

    @Test
    fun dayTwoTestPartTwo() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-2-test.txt").readLines()
        assertEquals(6, testInput.size)

        fun traverseCourse(): Int {
            var horizontal = 0
            var aim = 0
            var depth = 0

            for (i in testInput.indices) {
                if (testInput[i].contains("forward")) {
                    horizontal += testInput[i].substring(testInput[i].length - 1).toInt()
                    depth += (aim * testInput[i].substring(testInput[i].length - 1).toInt())
                } else if (testInput[i].contains("down")) {
                    aim += testInput[i].substring(testInput[i].length - 1).toInt()
                } else {
                    aim -= testInput[i].substring(testInput[i].length - 1).toInt()
                }
            }

            return depth * horizontal
        }
        assertEquals(900, traverseCourse()) //900 är det förväntade värdet som anges på AOC hemsida avseende testdatat
    }

    @Test
    fun dayTwoActualPartTwo() {
        val testInput =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-2-actual.txt").readLines()
        fun traverseCourse(): Int {
            var horizontal = 0
            var aim = 0
            var depth = 0

            for (i in testInput.indices) {
                if (testInput[i].contains("forward")) {
                    horizontal += testInput[i].substring(testInput[i].length - 1).toInt()
                    depth += (aim * testInput[i].substring(testInput[i].length - 1).toInt())
                } else if (testInput[i].contains("down")) {
                    aim += testInput[i].substring(testInput[i].length - 1).toInt()
                } else {
                    aim -= testInput[i].substring(testInput[i].length - 1).toInt()
                }
            }

            return depth * horizontal
        }
        println(traverseCourse())

    }
}