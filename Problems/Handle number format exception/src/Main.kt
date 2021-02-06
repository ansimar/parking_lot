import java.lang.Exception

fun parseCardNumber(cardNumber: String): Long {
    val expr = Regex("^\\d{4} \\d{4} \\d{4} \\d{4}\$")
    if (expr.matches(cardNumber)){
        return cardNumber.replace(" ", "").toLong()
    }else throw Exception("Wrong number!")
}