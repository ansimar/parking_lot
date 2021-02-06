import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val a = scanner.nextInt()
    val b = scanner.nextInt()

    divide(a, b)
}

fun divide(a: Int, b: Int) {
    if (b == 0){
        println("Division by zero, please fix the second argument!")
    }else println(a / b)
}
