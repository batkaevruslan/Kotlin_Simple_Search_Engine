import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val inputString = scanner.next()
    var firstHalfSum = 0
    for (index in 0 until inputString.length / 2) {
        firstHalfSum += inputString[index].toInt()
    }
    var secondHalfSum = 0
    for (index in inputString.length / 2 until inputString.length) {
        secondHalfSum += inputString[index].toInt()
    }
    if (secondHalfSum == firstHalfSum) {
        println("YES")
    } else {
        println("NO")
    }
}