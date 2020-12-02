import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val inputDateString = scanner.next()
    val dateParts = inputDateString.split("-")
    println("${dateParts[1]}/${dateParts[2]}/${dateParts[0]}")
}