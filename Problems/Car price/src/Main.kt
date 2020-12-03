import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val parameterName = scanner.nextLine()
    val parameterValue = scanner.nextInt()
    when (parameterName) {
        "old" -> println(getPrice(old = parameterValue))
        "passed" -> println(getPrice(passed = parameterValue))
        "speed" -> println(getPrice(speed = parameterValue))
        "auto" -> println(getPrice(auto = parameterValue))
    }
}

fun getPrice(old: Int = 5, passed: Int = 100_000, speed: Int = 120, auto: Int = 0): Int {
    val initialPrice = 20_000
    return initialPrice - old * 2000 - 200 * (passed / 10_000) + (speed - 120) * 100 + auto * 1500
}
