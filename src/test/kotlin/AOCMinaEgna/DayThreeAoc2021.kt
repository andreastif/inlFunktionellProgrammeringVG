package AOCMinaEgna

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File


class DayThreeAoc2021 {

    @Test
    fun dayThreeTestPartOne() {
        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-3-test.txt").readLines()
        assertEquals(12, testInput.size)

        fun powerConsumption(): Long {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in testInput.indices) {
                println("index [i] ${testInput[i]}")
                for (j in 0 until testInput[i].length) {
                    println("index [i][j] ${testInput[i][j]}, j=$j")
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = testInput[i][j].digitToInt()
                        else -> compiledBits[j] = count + testInput[i][j].digitToInt()
                    }
                }
            }

            println(compiledBits) //om key har ett value mindre än hälften av antalet rader innebär det att värdet är 0, annars 1

            var gamma = ""
            compiledBits.forEach { (key, value) -> gamma += if (value > testInput.size / 2) "1" else "0" }
            println("gamma: $gamma")
            var epsilon = ""
            gamma.forEach { x -> epsilon += if (x.toString() == "1") "0" else "1" }
            println("epsilon: $epsilon")

            //konverterar från bas 2 (binärt) till decimal.
            return gamma.toLong(2) * epsilon.toLong(2)
        }
        assertEquals(198, powerConsumption()) //198 är det förväntade värdet som anges på AOC hemsida avseende testdatat
    }

    @Test
    fun dayThreeActualPartOne() {
        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-3-actual.txt").readLines()

        fun powerConsumption(): Long {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in testInput.indices) {
                for (j in 0 until testInput[i].length) {
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = testInput[i][j].digitToInt()
                        else -> compiledBits[j] = count + testInput[i][j].digitToInt()
                    }
                }
            }
            println(compiledBits) //om key har ett value mindre än hälften av antalet rader innebär det att värdet är 0, annars 1
            var gamma = ""
            compiledBits.forEach { (_, value) -> gamma += if (value > testInput.size / 2) "1" else "0" }
            println("gamma: $gamma")
            var epsilon = ""
            gamma.forEach { x -> epsilon += if (x.toString() == "1") "0" else "1" }
            println("epsilon: $epsilon")

            //konverterar från bas 2 (binärt) till decimal.
            return gamma.toLong(2) * epsilon.toLong(2)
        }
        println(powerConsumption())
    }

    @Test
    fun dayThreeTestPartTwo() {
        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-3-test.txt").readLines()
        assertEquals(12, testInput.size)

        fun calcOxygenRating(oxygenList: List<String>, bitIndex: Int): String {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in oxygenList.indices) {
                println("index [i] ${oxygenList[i]}")
                for (j in 0 until oxygenList[i].length) {
                    println("index [i][j] ${oxygenList[i][j]}, j=$j")
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = oxygenList[i][j].digitToInt()
                        else -> compiledBits[j] = count + oxygenList[i][j].digitToInt()
                    }
                }
            }

            println("compiled bits: $compiledBits")
            println("(oxygenList.size.toDouble() / 2): ${(oxygenList.size.toDouble() / 2)}")
            println("(oxygenList.size): ${(oxygenList.size)}")
            println(oxygenList)

            var theBit: String = if (oxygenList.size > 1) {
                if (compiledBits[bitIndex]!! < (oxygenList.size.toDouble() / 2)) {
                    val listToSend = oxygenList.filter { x -> x[bitIndex] == '0' }
                    calcOxygenRating(listToSend, bitIndex + 1)
                } else {
                    val listToSend = oxygenList.filter { x -> x[bitIndex] == '1' }
                    calcOxygenRating(listToSend, bitIndex + 1)
                }
            } else {
                oxygenList.last()
            }

            return theBit
        }

        fun calcCo2ScrubberRating(co2List: List<String>, bitIndex: Int): String {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in co2List.indices) {
                for (j in 0 until co2List[i].length) {
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = co2List[i][j].digitToInt()
                        else -> compiledBits[j] = count + co2List[i][j].digitToInt()
                    }
                }
            }
            var theBit: String = if (co2List.size > 1) {
                if (compiledBits[bitIndex]!! < (co2List.size.toDouble() / 2)) {
                    val listToSend = co2List.filter { x -> x[bitIndex] == '1' }
                    calcCo2ScrubberRating(listToSend, bitIndex + 1)
                } else {
                    val listToSend = co2List.filter { x -> x[bitIndex] == '0' }
                    calcCo2ScrubberRating(listToSend, bitIndex + 1)
                }
            } else {
                co2List.last()
            }
            return theBit
        }

        val oxygen = calcOxygenRating(testInput, 0)
        val coSup = calcCo2ScrubberRating(testInput, 0)


        //testar att vi får ut rätt binära tal
        assertEquals("10111", oxygen)
        assertEquals("01010", coSup)

        //230 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        assertEquals(230, oxygen.toLong(2) * coSup.toLong(2))

    }


    @Test
    fun dayThreeActualPartTwo() {
        val testInput = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-3-actual.txt").readLines()
        assertEquals(1000, testInput.size)

        fun oxygenRating(oxygenList: List<String>, bitIndex: Int): String {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in oxygenList.indices) {
                println("index [i] ${oxygenList[i]}")
                for (j in 0 until oxygenList[i].length) {
                    println("index [i][j] ${oxygenList[i][j]}, j=$j")
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = oxygenList[i][j].digitToInt()
                        else -> compiledBits[j] = count + oxygenList[i][j].digitToInt()
                    }
                }
            }

            println("compiled bits: $compiledBits")
            println("(oxygenList.size.toDouble() / 2): ${(oxygenList.size.toDouble() / 2)}")
            println("(oxygenList.size): ${(oxygenList.size)}")
            println(oxygenList)
            var theBit: String = if (oxygenList.size > 1) {
                if (compiledBits[bitIndex]!! < (oxygenList.size.toDouble() / 2)) {
                    val listToSend = oxygenList.filter { x -> x[bitIndex] == '0' }
                    oxygenRating(listToSend, bitIndex + 1)
                } else {
                    val listToSend = oxygenList.filter { x -> x[bitIndex] == '1' }
                    oxygenRating(listToSend, bitIndex + 1)
                }
            } else {
                oxygenList.last()
            }

            return theBit
        }

        fun co2Sup(co2List: List<String>, bitIndex: Int): String {
            val compiledBits = mutableMapOf<Int, Int>()
            for (i in co2List.indices) {
                for (j in 0 until co2List[i].length) {
                    when (val count = compiledBits[j]) {
                        null -> compiledBits[j] = co2List[i][j].digitToInt()
                        else -> compiledBits[j] = count + co2List[i][j].digitToInt()
                    }
                }
            }
            var theBit: String = if (co2List.size > 1) {
                if (compiledBits[bitIndex]!! < (co2List.size.toDouble() / 2)) {
                    val listToSend = co2List.filter { x -> x[bitIndex] == '1' }
                    co2Sup(listToSend, bitIndex + 1)
                } else {
                    val listToSend = co2List.filter { x -> x[bitIndex] == '0' }
                    co2Sup(listToSend, bitIndex + 1)
                }
            } else {
                co2List.last()
            }
            return theBit
        }

        val oxygen = oxygenRating(testInput, 0)
        val coSup = co2Sup(testInput, 0)

        println(oxygen)
        println(coSup)

        println(oxygen.toLong(2) * coSup.toLong(2))

    }
}