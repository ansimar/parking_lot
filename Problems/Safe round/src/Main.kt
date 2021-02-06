import kotlin.math.round

fun main() {
    val number: Double = readLine()!!.toDouble()
    val new: Double? = if (number <= 1000) number else null
    println(new?.let { round(new).toInt() } ?: 0)
}