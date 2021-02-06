import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val index = scanner.nextInt()
    val word = scanner.next()
    if (index >= word.length || index < 0){
        println("There isn't such an element in the given string, please fix the index!")
    }else println(word[index])
}