package product

enum class ProductType {
    NORMAL,
    HIGH_DEMAND
}

class Product(
    val id: Int,
    val SKU: String,
    val name: String,
    val price: Double,
    val type: ProductType,
    val image: String
)