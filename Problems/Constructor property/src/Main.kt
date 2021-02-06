fun main() {
    val timerValue = readLine()!!.toInt()
    val timer = ByteTimer(timerValue)
    println(timer.time)
}

class ByteTimer(_time: Int) {
    var time = 0
    init{
        time = when {
            _time < -128 -> -128
            _time > 127 -> 127
            else -> _time
        }
    }
}