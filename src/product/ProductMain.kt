package product

fun main() {
    val products = getProducts()
    val inventories = getInventories()
    val finalProducts = getFinalProducts(products, inventories)
    for (finalProduct in finalProducts){
        println(finalProduct)
    }
}

fun getProducts(): List<Product> {
    val productsCall = ApiClient.apiService.getProducts()
    val response = productsCall.execute()
    val products = response.body()!!

    return products
}

fun getInventories(): List<Inventory> {
    val inventoriesCall = ApiClient.apiService.getInventories()
    val response = inventoriesCall.execute()
    val inventories = response.body()!!

    return inventories
}

fun getFinalProducts(products: List<Product>, inventories: List<Inventory>): List<FinalProduct> {
    return products.map { product ->
        var quantity = 0
        for (inventory in inventories) {
            if (inventory.SKU == product.SKU) {
                quantity += inventory.quantity
            }
        }
        FinalProduct(product.SKU, product.name, product.type, product.price, quantity, product.image)
    }

}