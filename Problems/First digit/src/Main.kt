import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val word = scanner.nextLine()
    for (ch in word) {
        if(ch.isDigit()) {
            println(ch)
            break
        }
    }
}