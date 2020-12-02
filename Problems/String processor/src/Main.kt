import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    val firstString = scanner.nextLine()
    val operator = scanner.nextLine()
    val secondString = scanner.nextLine()
    when (operator) {
        "equals" -> println(firstString == secondString)
        "plus" -> println(firstString + secondString)
        "endsWith" -> println(firstString.endsWith(secondString))
        else -> println("Unknown operation")
    }
    // write your code here
}