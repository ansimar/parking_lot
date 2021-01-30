package parking

import java.util.*
import kotlin.system.exitProcess

data class Spot(val numberPlate: String, val color: String)

val PARKING_NOT_CREATED = "Sorry, a parking lot has not been created."

fun main() {
    var parkingSpots = mutableMapOf<String, Spot?>()
    //createParkingMap(parkingSpots, args?.get(0).toInt())
    val scanner = Scanner(System.`in`)
    var parkingSize = 0
    do{
        val args = scanner.nextLine().split(" ").toTypedArray()
        when (args?.get(0)){
            "create" -> {
                parkingSize = args?.get(1).toInt()
                createParkingMap(parkingSpots, parkingSize)
            }
            "status" -> printStatus(parkingSpots)
            "park"  -> parkCar(args, parkingSpots, parkingSize)
            "leave" -> leaveSpot(args, parkingSpots)
            "reg_by_color" -> regByColor(args, parkingSpots, true)
            "spot_by_color" -> regByColor(args, parkingSpots, false)
            "spot_by_reg" -> spotByReg(args, parkingSpots)
            "exit" -> exitProcess(0)
        }
    }while (true)
}

fun spotByReg(args: Array<String>, parkingSpots: MutableMap<String, Spot?>) {
    if (checkParkingHasBeenCreated(parkingSpots)) return
    args[1]?.let { numberPlate ->
        var answer = ""
        parkingSpots.forEach { (key, value) ->
            value?.let { spot ->
                if (spot.numberPlate.equals(numberPlate, ignoreCase = true))
                    answer = key
            }
        }
        if (answer.isBlank()){
            println("No cars with registration number $numberPlate were found.")
        }else{
            println(answer)
        }
    }
}

fun regByColor(args: Array<String>, parkingSpots: MutableMap<String, Spot?>, showNumberPlate: Boolean) {
    if (checkParkingHasBeenCreated(parkingSpots)) return
    args[1]?.let { color ->
        var answer = ""
        parkingSpots.forEach { (key, value) ->
            value?.let { spot ->
                if (spot.color.equals(color, ignoreCase = true))
                    if (showNumberPlate){
                        answer += if (answer.length == 0) spot.numberPlate else ", " + spot.numberPlate
                    }else{
                        answer += if (answer.length == 0) key else ", $key"
                    }

            }
        }
        if (answer.isBlank()){
            println("No cars with color $color were found.")
        }else{
            println(answer)
        }
    }
}

fun printStatus(parkingSpots: MutableMap<String, Spot?>) {
    if (checkParkingHasBeenCreated(parkingSpots)) return
    val empty = (parkingSpots.values.filter { spot -> spot != null }.isEmpty())
    if (empty){
        println("Parking lot is empty.")
    }else{
        parkingSpots.forEach { (key, spot) ->
            spot?.let { spot ->
                println("$key ${spot.numberPlate} ${spot.color}")
            }
        }
    }
}

fun createParkingMap(parkingSpots: MutableMap<String, Spot?>, parkingSize: Int){
    parkingSpots.clear()
    for(i in 1..parkingSize){
        parkingSpots[i.toString()] = null
    }
    println("Created a parking lot with ${parkingSize} spots.")
}

fun leaveSpot(args: Array<String>, parkingSpots: MutableMap<String, Spot?>) {
    if (checkParkingHasBeenCreated(parkingSpots)) return
    if (args?.get(1) != null){
        parkingSpots[args?.get(1)] = null
        println("Spot ${args?.get(1)} is free.")
    }
}

private fun parkCar(args: Array<String>, parkingSpots: MutableMap<String, Spot?>, parkingSize: Int) {
    if (checkParkingHasBeenCreated(parkingSpots)) return
    var parked = false
    for(i in 1..parkingSize){
        if (parkingSpots[i.toString()] == null){
            parkingSpots[i.toString()] = Spot(args?.get(1), args?.get(2))
            println("${args?.get(2)} car parked in spot ${i.toString()}.")
            parked = true
            break
        }
    }
    if (!parked) println("Sorry, the parking lot is full.")
}

private fun checkParkingHasBeenCreated(parkingSpots: MutableMap<String, Spot?>): Boolean {
    if (parkingSpots.isEmpty()) {
        println(PARKING_NOT_CREATED)
        return true
    }
    return false
}

