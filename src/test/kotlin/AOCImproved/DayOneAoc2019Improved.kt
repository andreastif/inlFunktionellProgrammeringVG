package AOCImproved

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayOneAoc2019Improved {

    @Test
    fun improvedDayOne() {

        //Exemplet är hämtat från https://todd.ginsberg.com/post/advent-of-code/2019/day1/
        //Todd använder här en extension function vilket var intressant samt keyword this/it. I min egna lösning
        // är jag mer "java" orienterad och använder pilnotation istället för it.
        // Värt att notera att hans lösning använder sumBy vilket idag är deprecated, man skall istället använda sumOf.
        //Lärdomar: Extension functions samt att använda it.funktionsAnrop().


        val input = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-1-actual.txt").readLines()
        val modules: List<Int> = input.map { it.toInt() }

        fun Int.fuel(): Int = (this / 3) - 2

        fun solvePart1(): Int =
            modules.sumBy { it.fuel() }

        fun Int.fuelWithFuel(): Int =
            if(this < 9)  {
                0
            } else {
                val fuel = this.fuel()
                fuel + fuel.fuelWithFuel()
            }

        fun solvePart2(): Int =
            modules.sumBy { it.fuelWithFuel() }

        assertEquals(3386686, solvePart1()) //3386686 är mitt korrekta svar till AOC, vilket stämmer här
        assertEquals(5077155, solvePart2()) //5077155 är mitt korrekta svar till AOC, vilket stämmer här


    }

}