
import HuvudprogramVGDEL2.Run
import org.junit.Test
import org.junit.jupiter.api.Assertions.*

internal class MainKtTest {

    @Test
    fun recursiveSanta() {
        val res = Run();
        val tomtensArbetare = res.getAllReportingSantas(res.tomten);
        assertEquals(14,tomtensArbetare.size)
        assertEquals("Blyger", tomtensArbetare[4].name)
        assertEquals("Bladlusen", tomtensArbetare[13].name)
        println(tomtensArbetare)

        val buttersArbetare = res.getAllReportingSantas(res.butter);
        assertEquals(7, buttersArbetare.size)
        assertEquals("Rådjuret", buttersArbetare[0].name)
        assertEquals("Bladlusen", buttersArbetare[6].name)
        println(buttersArbetare)
    }
}