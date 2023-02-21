package AOCImproved

import org.junit.Test
import org.junit.jupiter.api.Assertions
import java.io.File

class DayTwoAoc2019Improved {

    @Test
    fun improvedDayTwo() {
        //Exemplet är hämtat från https://todd.ginsberg.com/post/advent-of-code/2019/day2/
        //Todd läser in exemplet som en hel sträng och splittar därefter det till en intArray. Syftet med det är intressant,
        //Återigen vill han använda sig av extension functions för att lösa problemet!
        //Lärdomar: Hur vi kan använda extension functions på intArrayen och i samband med det, nyttja copyOf.

        val input: String = File("src/main/kotlin/HuvudprogramVGDEL1AoC2019/day-2-actual.txt").readText()
        val memory: IntArray = input.split(",").map { it.toInt() }.toIntArray()

        //Todds extension functions [Förklaring: if we read position 1 and it has the value 12, we would need to get/set our real value from/at position 12.]
        fun IntArray.setRef(at: Int, value: Int) {
            this[this[at]] = value
        }
        fun IntArray.getRef(at: Int): Int {
           return this[this[at]]
        }

        //skillnaden mot min lösning är att todd nyttjar sina extension functions på intArrayen och returnerar ut en lista som är en kopia
        //copyOf finns tyvärr inte i mutable list, utan endast på intArray. I min lösning uppdaterar jag den befintliga listan som sätts
        //när vi laddar in datat. I övrigt ser våra lösningar närmast identiska ut.
        //problemet med todds är att han inte initierar sin noun och verb till 2 och 12, så var tvungen att ändra det.

        fun runProgram(memory: IntArray, noun: Int, verb: Int): Int {
            val memoryCopy = memory.copyOf().apply {
                this[1] = noun
                this[2] = verb
            }
            (memoryCopy.indices step 4).forEach { ip ->
                when (memoryCopy[ip]) {
                    1 -> memoryCopy.setRef(ip + 3, memoryCopy.getRef(ip + 1) + memoryCopy.getRef(ip + 2))
                    2 -> memoryCopy.setRef(ip + 3, memoryCopy.getRef(ip + 1) * memoryCopy.getRef(ip + 2))
                    99 -> return memoryCopy[0]
                }
            }
            throw IllegalStateException("Program ran out of instructions")
        }

        fun solvePart1(noun: Int = 12, verb: Int = 2): Int =
            runProgram(memory, noun, verb)
        println(solvePart1())

        //del 1
        Assertions.assertEquals(4576384, solvePart1()) //vi ser här att todds och min lösning ger samma resultat

        //min och todds del 2 ser i princip helt identiska ut också. Hans har lite snyggare indentering och
        //har skickat in target som värde till funktionen istället.
        fun solvePart2(target: Int = 19_690_720): Int {
            (0..99).forEach { noun ->
                (0..99).forEach { verb ->
                    if (runProgram(memory, noun, verb) == target) {
                        return (noun * 100) + verb
                    }
                }
            }
            throw IllegalStateException("Cannot find starting noun/verb that end up with $target")
        }

        //del 2
        Assertions.assertEquals(5398,solvePart2()) //vi ser här att todds och min lösning ger samma resultat


    }
}