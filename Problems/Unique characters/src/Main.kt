import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val word = scanner.nextLine()
    var count = 0
    loop@ for (i in word.indices) {
        for (y in word.indices) {
            if (i != y && word[i] == word[y]) {
                continue@loop
            }
        }
        count++
    }
    println(count)
}
