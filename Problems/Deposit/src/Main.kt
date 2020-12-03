import java.util.*
import kotlin.math.pow

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val parameterName = scanner.nextLine()
    val parameterValue = scanner.nextInt()
    when (parameterName) {
        "amount" -> println(calculateInterest(amount = parameterValue))
        "percent" -> println(calculateInterest(percent = parameterValue))
        "years" -> println(calculateInterest(years = parameterValue))
    }
}

fun calculateInterest(amount: Int = 1000, percent: Int = 5, years: Int = 10): Int {
    return (amount * (1 + percent.toDouble() / 100).pow(years.toDouble())).toInt()
}
