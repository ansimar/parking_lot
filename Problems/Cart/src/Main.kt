import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val productType = scanner.next()
    val price = scanner.nextInt()
    val product = Product(productType, price)
    println(totalPrice(product))
}

class Product(val productType: String, val price: Int)

fun totalPrice(product: Product): Int{
    return when(product.productType){
        "headphones" -> (product.price + product.price * 0.11).toInt()
        "smartphone" -> (product.price + product.price * 0.15).toInt()
        "tv" -> (product.price + product.price * 0.17).toInt()
        "laptop" -> (product.price + product.price * 0.19).toInt()
        else -> product.price
    }
}
