import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class MainKtTest {

    @Test
    fun `0 should be transform to A`() {
        assertEquals("A", decimalTo26Base(0))
    }

    @Test
    fun `25 should be transform to Z`() {
        assertEquals("Z", decimalTo26Base(25))
    }

    @Test
    fun `26 should be transform to AA`() {
        assertEquals("AA", decimalTo26Base(26))
    }

    @Test
    fun `should throw an error when result is over ZZZ`() {
        val exception = assertThrows(Exception::class.java) {
            decimalTo26Base(18278)
        }

        assertEquals("cannot over the biggest of ZZZ", exception.message)
    }

    @Test
    fun `number is 1 and length is 2 should be transform excel columns including A,B`() {
        assertEquals(listOf("A", "B"), transformNumbersToExcelColumnNames(1, 2))
    }

    @Test
    fun `number is 26 and length is 3 should be transform excel columns including Z,AA,AB`() {
        assertEquals(listOf("Z", "AA","AB"), transformNumbersToExcelColumnNames(26, 3))
    }

    @Test
    fun `should throw a error when columns including the item over ZZZ`() {
        val exception = assertThrows(Exception::class.java) {
            transformNumbersToExcelColumnNames(18278, 2)
        }

        assertEquals("cannot over the biggest of ZZZ", exception.message)
    }
}