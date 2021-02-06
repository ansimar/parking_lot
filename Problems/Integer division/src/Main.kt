import java.lang.NumberFormatException
import java.util.*

fun intDivision(x: String, y: String): Int {
    return try {
        val xAsInt = x.toInt()
        val yAsInt = y.toInt()
        xAsInt / yAsInt
    } catch (e: NumberFormatException) {
        println("Read values are not integers.")
        0
    } catch (e: Exception) {
        println("Exception: division by zero!")
        0
    }
}

fun main() {
    val scanner = Scanner(System.`in`)
    val x = scanner.next()
    val y = scanner.next()
    println(intDivision(x, y))
}