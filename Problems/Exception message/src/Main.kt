
fun main(){
    try {
        problemFunction()
    }
    catch (e: Exception) {
        println(e.message)
    }
}

fun problemFunction() {
    1 / 0
}
// ...