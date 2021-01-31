import java.util.*

data class SpeedControl(val speed: Int, val limit: Int = 60)

fun main() {
    val scanner = Scanner(System.`in`)
    val speed: Int =  scanner.nextLine().toInt()
    when(val limit =  scanner.nextLine()){
        "no limit" -> printMessage(SpeedControl(speed = speed))
        else -> printMessage(SpeedControl(speed = speed, limit = limit.toInt()))
    }
}

fun printMessage(speedControl: SpeedControl) {
    val result = speedControl.limit - speedControl.speed
    if (result < 0){
        println("Exceeds the limit by ${result * -1} kilometers per hour")
    }else{
        println("Within the limit")
    }
}
