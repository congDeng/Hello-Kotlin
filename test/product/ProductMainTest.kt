package product

import org.junit.jupiter.api.Test

import org.junit.jupiter.api.Assertions.*

class ProductMainTest {
    private val products: ArrayList<Product> =
        arrayListOf(
            Product(1, "ABC123", "Electronic Watch", 299.99, ProductType.NORMAL, "image1.png"),
            Product(2, "ABC456", "Sports Shoes", 499.99, ProductType.HIGH_DEMAND, "image2.png")
        )

    private val inventories: ArrayList<Inventory> =
        arrayListOf(
            Inventory(1, "ABC123", "CN_NORTH", 120),
            Inventory(2, "ABC123", "US_WEST", 20),
            Inventory(3, "ABC456", "US_WEST", 200)
        )

    private val finalProductsExpected: ArrayList<FinalProduct> = arrayListOf(
        FinalProduct("ABC123", "Electronic Watch", ProductType.NORMAL, 299.99, 140, "image1.png"),
        FinalProduct("ABC456", "Sports Shoes", ProductType.HIGH_DEMAND, 499.99, 200, "image2.png")
    )

    @Test
    fun `should get final products`() {
        val finalProducts = getFinalProducts(products, inventories)
        assertEquals(finalProductsExpected, finalProducts)
    }
}