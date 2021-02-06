import java.util.*

// do not change this data class
data class Box(val height: Int, val length: Int, val width: Int)

fun main() {
    val scanner = Scanner(System.`in`)
    val height = scanner.nextInt()
    val length1 = scanner.nextInt()
    val length2 = scanner.nextInt()
    val width = scanner.nextInt()

    val box1 = Box(height, length1, width)
    val box2 = box1.copy(length = length2)
    printBox(box1)
    printBox(box2)
}

fun printBox(box: Box) {
    println("Box(height=${box.height}, length=${box.length}, width=${box.width})")
}