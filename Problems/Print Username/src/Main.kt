import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val name = scanner.next()
    println("Hello, ${if (name == "HIDDEN") "secret user" else name}!")
}