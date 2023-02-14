import HuvudprogramVGDEL2.Run
import org.junit.Test
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.assertThrows

open class VGDEL2 {


    @Test
    fun testingIfRecursiveFunctionIsSummingCorrectly() {
        println("\nTOMTEN:")
        val res = Run()
        val tomtensArbetare = res.getAllReportingSantas(res.tomten)
        assertEquals(14, tomtensArbetare.size)
        assertTrue(tomtensArbetare.contains(res.blyger))
        assertTrue(tomtensArbetare.contains(res.bladlusen))
        println(tomtensArbetare)
        println(tomtensArbetare.size)

        println("\nBUTTER:")
        val buttersArbetare = res.getAllReportingSantas(res.butter)
        assertEquals(7, buttersArbetare.size)
        assertTrue(buttersArbetare.contains(res.radjuret))
        assertTrue(buttersArbetare.contains(res.bladlusen))
        println(buttersArbetare)
        println(buttersArbetare.size)

        println("\nBLADLUSEN:")
        val bladlusensArbetare = res.getAllReportingSantas(res.bladlusen)
        assertEquals(0, bladlusensArbetare.size)
        assertTrue(bladlusensArbetare.isEmpty())
        assertThrows<IndexOutOfBoundsException> {
            (bladlusensArbetare[0].name)
        }
        println(bladlusensArbetare)
        println(bladlusensArbetare.size)
    }

}