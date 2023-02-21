package AOCImproved

import org.junit.Test
import org.junit.jupiter.api.Assertions.assertEquals
import java.io.File

class DayOneAoc2021Improved {


    @Test
    fun dayOneImproved() {
        val input =
            File("src/main/kotlin/HuvudprogramVGDEL1AoC2021/day-1-test.txt").readLines().map { it.toInt() }
        //Exemplet hämtat från https://todd.ginsberg.com/post/advent-of-code/2021/day1/

        //Lärdomar: Kotlins nyttjande av
        // 1. zipWithNext i kombination med count
        // 2. it.first och it.second
        // 3. windowed


        //Todd använder på ett mycket vackert sätt zipWithNext med count. I min lösning är jag väldigt "Java"-minded
        //och bygger mer upp funktionen från grunden. Todd beskriver väl hur zipWithNext tar inputs och parar ihop dem och det är exakt
        //det här som nyttjas för att sedan jämföra paren inbördes med varandra! Väldigt snyggt utfört. Count räknar hur många av paren
        //som matchar mot condition i AOC uppgiften (dvs hur många par där det första värdet är mindre än det efterföljande värdet.

        fun solvePart1(): Int =
            input
                .zipWithNext()
                .count { it.first < it.second }
        //del 1
        assertEquals(7, solvePart1()) //7 är det förväntade värdet som anges på AOC hemsida avseende testdatat

        //Stjärnan i detta exempel är den inbyggda funktionen -Windowed- (har önskat att jag har haft den tidigare i java...)
        //Param 1 i windowed anger hur många värden vi vill gruppera till en egen lista, param 2 anger hur många steg
        //vi förflyttar oss i talserien i sidleds. Todd beskriver det enkelt:
        // By calling windowed(3, 1) on it (meaning: window size 3, step over 1 each time): we would end up with this list: ((1, 2, 3), (2, 3, 4), (3, 4, 5))
        //Gillade det här riktigt mycket.
        //resterande kod är självförklarande, han summerar fönstret och zippar det vidare i värdepar och löser det som del 1

        fun solvePart2(): Int =
            input
                .windowed(3, 1) { it.sum() }
                .zipWithNext()
                .count { it.first < it.second }

        //del 2
        assertEquals(5, solvePart2()) // 5 är det förväntade värdet som anges på AOC hemsida avseende testdatat

    }
}