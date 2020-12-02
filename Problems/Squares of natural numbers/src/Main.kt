import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val n = scanner.nextInt()
    var number = 1
    var square = number * number
    while (square <= n) {
        println(square)
        number++
        square = number * number
    }
}