import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var sum = 0
    do {
        val digit = scanner.nextInt()
        sum += digit
    } while (digit != 0)

    println(sum)
}