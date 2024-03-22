package product

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class FinalProductTest {

    @Test
    fun `price should be equal to itself when type is normal`() {
        val finalProduct = FinalProduct("ABC123", "Electronic Watch", ProductType.NORMAL, 299.99, 140, "image1.png")
        assertEquals(299.99, finalProduct.price)
    }

    @Test
    fun `price should be equal to itself when type is high_demand and quantity is over 100`() {
        val finalProduct =
            FinalProduct("ABC123", "Electronic Watch", ProductType.HIGH_DEMAND, 299.99, 140, "image1.png")
        assertEquals(299.99, finalProduct.price)
    }

    @Test
    fun `price should be equal to 150 percent of itself when type is high_demand and quantity is less 30`() {
        val finalProduct =
            FinalProduct("ABC123", "Electronic Watch", ProductType.HIGH_DEMAND, 300.00, 10, "image1.png")
        assertEquals(450.00, finalProduct.price)
    }

    @Test
    fun `price should be equal to 120 percent of itself when type is high_demand and quantity is over 30 and less 100`() {
        val finalProduct =
            FinalProduct("ABC123", "Electronic Watch", ProductType.HIGH_DEMAND, 300.00, 50, "image1.png")
        assertEquals(360.00, finalProduct.price)
    }

}