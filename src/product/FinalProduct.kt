package product

class FinalProduct(
    val SKU: String,
    val name: String,
    val type: ProductType,
    var price: Double,
    val quantity: Int,
    val image: String
) {
    init {
        if (type == ProductType.HIGH_DEMAND) {
            price = when (quantity) {
                in 1..30 -> price * 1.5
                in 31..100 -> price * 1.2
                else -> price
            }
        }
    }

    override fun toString(): String {
        return "(SKU='$SKU', name='$name', price=$price, quantity=$quantity, image=$image)"
    }
}