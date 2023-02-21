package AOCImproved

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayTwoAoc2021Improved {

    //todds command klass med companion object
    private class Command(val name: String, val amount: Int) {
        companion object {
            fun of(input: String) = input.split(" ").let { Command(it.first(), it.last().toInt()) }
        }
    }

    //todds submarine klass
    private data class Submarine(
        val depth: Int = 0,
        val position: Int = 0,
        val aim: Int = 0
    ) {
        fun answer() = depth * position

        fun movePart1(command: Command): Submarine =
            when(command.name) {
                "forward" -> copy(position = position + command.amount)
                "down" -> copy(depth = depth + command.amount)
                "up" -> copy(depth = depth - command.amount)
                else -> error("Invalid command")
            }

        fun movePart2(command: Command) =
            when (command.name) {
                "forward" -> copy(
                    position = position + command.amount,
                    depth = depth + (aim * command.amount)
                )
                "down" -> copy(aim = aim + command.amount)
                "up" -> copy(aim = aim - command.amount)
                else -> error("Invalid command")
            }
    }

    @Test
    fun improvedDayTwo() {
        //Exemplet är hämtat från https://todd.ginsberg.com/post/advent-of-code/2021/day2/
        val input = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-2-actual.txt").readLines()

        //I följande exempel gör todd och jag i princip samma sak men han är mer "flashy". Tycker att det kanske är onödigt invecklat ibland. Men syftet
        //är antagligen att lära sig och därför göra det på detta vis.

        //Lärdomar: Användandet av companion objects i klasser! Hans användning av ett companion object var intressant
        //Min förståelse av det är att det är som att man använder ett singleton objekt, man behöver inte skapa och lagra objektet innan det används.
        //Vidare skapar han ett objekt av typen Submarine som är en dataklass i syfte att använda den inbyggda metoden Copy.

        //som en kommentar känns det också väldigt märkligt att skapa upp ett nytt submarine objekt och skicka in i fold metoden varje gång
        //han itererar över alla kommandon. Kreativt, hade inte kommit på det själv. I min metod är jag mer Java lagd och använder variablerna deklarerade med nyckelordet: var
        //och lagrar alla resultat däri, Todd har vänt på steken istället!

        val commands = input.map { Command.of(it) }

        fun solvePart1(): Int =
            commands.fold(Submarine()) { submarine, command -> submarine.movePart1(command) }.answer()

        //del 1
//        assertEquals(150,solvePart1()) //150 är det förväntade värdet som anges på AOC hemsida avseende testdatat
        println(solvePart1()) // = 1714950 med actual.txt, samma som min egna lösning

        //del 2
        fun solvePart2(): Int =
            commands.fold(Submarine()) { submarine, command -> submarine.movePart2(command) }.answer()
//        assertEquals(900, solvePart2()) //900 är det förväntade värdet som anges på AOC hemsida avseende testdatat
                println(solvePart2()) // = 1281977850 med actual.txt, samma som min egna lösning



    }


}