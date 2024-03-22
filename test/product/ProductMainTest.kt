package product

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProductMainTest {
    private val products: List<Product> =
        listOf(
            Product(1, "ABC123", "Electronic Watch", 299.99, ProductType.NORMAL, "image1.png"),
            Product(2, "ABC456", "Sports Shoes", 499.99, ProductType.HIGH_DEMAND, "image2.png")
        )

    private val inventories: List<Inventory> =
        listOf(
            Inventory(1, "ABC123", "CN_NORTH", 120),
            Inventory(2, "ABC123", "US_WEST", 20),
            Inventory(3, "ABC456", "US_WEST", 200)
        )


    @Test
    fun `final product quantity should equal to expected value`() {
        val finalProducts = getFinalProducts(products, inventories)
        assertEquals(140, finalProducts[0].quantity)
        assertEquals(200, finalProducts[1].quantity)
    }
}