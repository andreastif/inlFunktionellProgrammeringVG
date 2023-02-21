package AOCImproved

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayThreeAoc2021Improved {

    @Test
    fun improvedDayThree() {
        //Exempel hämtat från https://todd.ginsberg.com/post/advent-of-code/2021/day3/
        // Detta är nog den uppgift som VERKLIGEN är en STOR förändring från min egna lösning
        //i min egna lösning använder jag en HashMap som jag mappar inputs från filen till en ny map (lärorikt)
        //men denna lösning todd har är mycket elegant och välskriven. Jag känner mig nästan korkad när jag jämför min kod med hans (del 2 lösningen)!!
        //dessutom använder jag rekursion vilket todd inte gör. två helt olika lösningar, varpå hans är mycket bättre...

        //Lärdom: Kom ihåg att nyttja count och map samt joinToString metoden. Ännu en gång är todds extension funktions väldigt användbara.
        // Jag valde dock hashmap i min lösning för att jag också ville lära mig mer kring det (bra i sig, men blev ett riktigt hinder för del 2), satt i bokstavligen i 2 dagar med att lösa del 2....

        val input = File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-3-test.txt").readLines()

        //här ser det nästan likadant ut som i min egna lösning med hur han dividerar och summerar. Jag summerar in det i en hashmap istället och hämtar ut mitt binära tal

        fun solvePart1(): Int {
            val gamma = input.first().indices.map { column -> //väldigt snyggt här måste jag säga, börjar med första input och itererar sen över med indices metoden och mappar!
                if (input.count { it[column] == '1' } > input.size / 2) '1' else '0'
            }.joinToString("")

            val epsilon = gamma.map { if(it == '1') '0' else '1' }.joinToString("")

            return gamma.toInt(2) * epsilon.toInt(2)
        }

        //del 1
        assertEquals(198, solvePart1()) //198 är det förväntade värdet som anges på AOC hemsida avseende testdatat


        //hitta längsta listan
        fun <T> Pair<List<T>,List<T>>.longest(): List<T> =
            if(first.size >= second.size) first else second

        //hitta kortaste listan
        fun <T> Pair<List<T>,List<T>>.shortest(): List<T> =
            if(first.size < second.size) first else second

        fun List<String>.bitwiseFilter(keepMostCommon: Boolean): String =
            first().indices.fold(this) { inputs, column ->
                if (inputs.size == 1) inputs else {
                    val split = inputs.partition { it[column] == '1' }
                    if(keepMostCommon) split.longest() else split.shortest()
                }
            }.first()

        fun solvePart2(): Int =
            input.bitwiseFilter(true).toInt(2) * input.bitwiseFilter(false).toInt(2)
        //del 2
        assertEquals(230, solvePart2()) //230 är det förväntade värdet som anges på AOC hemsida avseende testdatat

    }

}