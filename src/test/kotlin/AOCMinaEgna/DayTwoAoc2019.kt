package AOCMinaEgna

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

open class DayTwoAoc2019 {

    @Test
    fun dayTwoTestPartOne() {
        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-2-test.txt").readLines()
        val updInput = testInput[0].split(",")
            .map { it.toInt() } as MutableList<Int>

        fun analyzeOpcode() {
            for (i in 0 until updInput.size step 4) {
                when (updInput[i]) {
                    99 -> break
                    1 -> {
                        val firstIndex = updInput[i + 1]
                        val secondIndex = updInput[i + 2]
                        val thirdIndex = updInput[i + 3]
                        val x = updInput[firstIndex] + updInput[secondIndex]; updInput[thirdIndex] = x
                    }

                    2 -> {
                        val firstIndex = updInput[i + 1]
                        val secondIndex = updInput[i + 2]
                        val thirdIndex = updInput[i + 3]
                        val x = updInput[firstIndex] * updInput[secondIndex]; updInput[thirdIndex] = x
                    }
                }
            }
        }
        analyzeOpcode()
        assertEquals(3500, updInput[0]) //3500 är det förväntade värdet som anges på AOC hemsida avseende testdatat
    }

    @Test
    fun dayTwoActualPartOne() {

        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-2-actual.txt").readLines()
        val updInput = testInput[0].split(",")
            .map { it.toInt() } as MutableList<Int>
        updInput[1] = 12
        updInput[2] = 2
        fun analyzeOpcode() {
            for (i in 0 until updInput.size step 4) {
                when (updInput[i]) {
                    99 -> break
                    1 -> {
                        val firstIndex = updInput[i + 1]
                        val secondIndex = updInput[i + 2]
                        val thirdIndex = updInput[i + 3]
                        val x = updInput[firstIndex] + updInput[secondIndex]; updInput[thirdIndex] = x
                    }

                    2 -> {
                        val firstIndex = updInput[i + 1]
                        val secondIndex = updInput[i + 2]
                        val thirdIndex = updInput[i + 3]
                        val x = updInput[firstIndex] * updInput[secondIndex]; updInput[thirdIndex] = x
                    }
                }
            }
        }

        analyzeOpcode()
        println(updInput[0])

    }

    @Test
    fun dayTwoTestPartTwo() {

        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-2-actual.txt").readLines()
        val updInput = testInput[0].split(",")
            .map { it.toInt() }

        fun analyzeOpcode(finallyUpdatedList: MutableList<Int>) : Int{
            for (i in 0 until finallyUpdatedList.size step 4) {
                when (finallyUpdatedList[i]) {
                    99 -> break
                    1 -> {
                        val firstIndex = finallyUpdatedList[i + 1]
                        val secondIndex = finallyUpdatedList[i + 2]
                        val thirdIndex = finallyUpdatedList[i + 3]
                        val x = finallyUpdatedList[firstIndex] + finallyUpdatedList[secondIndex]; finallyUpdatedList[thirdIndex] = x
                    }

                    2 -> {
                        val firstIndex = finallyUpdatedList[i + 1]
                        val secondIndex = finallyUpdatedList[i + 2]
                        val thirdIndex = finallyUpdatedList[i + 3]
                        val x = finallyUpdatedList[firstIndex] * finallyUpdatedList[secondIndex]; finallyUpdatedList[thirdIndex] = x
                    }
                }
            }
            return finallyUpdatedList[0]
        }

        fun updateInputsToFindVal() : Int {
            for (i in 0 until 100) {
                for (j in 0 until 100) {
                    val finallyUpdatedList = updInput.toMutableList()
                    finallyUpdatedList[1] = i
                    finallyUpdatedList[2] = j
                    if (analyzeOpcode(finallyUpdatedList) == 19690720) {
                        return (100*i+j)
                    }
                }
            }
            return 0
        }
        //finns ingen testdata för 2019 som fungerar med del 2, därav testar vi att metoden producerar
        //ett värde som används som input till nästa metod!
        assertEquals(152702, analyzeOpcode(updInput.toMutableList()))
        assertEquals(5398, updateInputsToFindVal()) //detta var mitt svar till AOC som blev korrekt.
    }

    @Test
    fun dayTwoActualPartTwo() {

        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-2-actual.txt").readLines()
        val updInput = testInput[0].split(",")
            .map { it.toInt() }

            fun analyzeOpcode(finallyUpdatedList: MutableList<Int>) : Int{
                for (i in 0 until finallyUpdatedList.size step 4) {
                    when (finallyUpdatedList[i]) {
                        99 -> break
                        1 -> {
                            val firstIndex = finallyUpdatedList[i + 1]
                            val secondIndex = finallyUpdatedList[i + 2]
                            val thirdIndex = finallyUpdatedList[i + 3]
                            val x = finallyUpdatedList[firstIndex] + finallyUpdatedList[secondIndex]; finallyUpdatedList[thirdIndex] = x
                        }

                        2 -> {
                            val firstIndex = finallyUpdatedList[i + 1]
                            val secondIndex = finallyUpdatedList[i + 2]
                            val thirdIndex = finallyUpdatedList[i + 3]
                            val x = finallyUpdatedList[firstIndex] * finallyUpdatedList[secondIndex]; finallyUpdatedList[thirdIndex] = x
                        }
                    }
                }
                return finallyUpdatedList[0]
            }

        fun updateInputsToFindVal() : Int {
            for (i in 0 until 100) {
                for (j in 0 until 100) {
                    val finallyUpdatedList = updInput.toMutableList()
                    finallyUpdatedList[1] = i
                    finallyUpdatedList[2] = j
                    if (analyzeOpcode(finallyUpdatedList) == 19690720) {
                       return (100*i+j)
                    }
                }
            }
            return 0
        }
        println(updateInputsToFindVal())
    }
}