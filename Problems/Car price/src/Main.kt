import java.util.*

data class Car(val old: Int = 5, val passed: Int = 100000, val speed: Int = 120, val automatic: Int = 0)

fun main() {
    val scanner = Scanner(System.`in`)
    val car = createCar(scanner.next(), scanner.nextInt())

    println(calculatePrize(car))
}

fun calculatePrize(car: Car): Int{
    val prize = 20000
    val ageAsset = car.old * 2000
    val speedAsset = (120 - car.speed) * 100
    val passedAsset = (car.passed / 10000) * 200
    val autoAsset = (- car.automatic) * 1500
    return prize - ageAsset - speedAsset - passedAsset - autoAsset
}

fun createCar(argument: String?, value: Int): Car {
    return when(argument){
        "old" -> Car(old = value)
        "passed" -> Car(passed = value)
        "speed" -> Car(speed = value)
        "auto" -> Car(automatic = value)
        else -> Car()
    }
}
