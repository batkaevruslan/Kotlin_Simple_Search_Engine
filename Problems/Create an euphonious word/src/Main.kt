import java.util.*

fun main() {
    val scanner = Scanner(System.`in`)
    val vowels = charArrayOf('a', 'e', 'i', 'o', 'u', 'y')
    val word = scanner.next()
    var numberOfVowelsInRow = 0
    var numberOfConsonantsInRow = 0
    var result = 0
    for (ch in word) {
        if (vowels.contains(ch)) {
            if (numberOfConsonantsInRow > 2) {
                result += (numberOfConsonantsInRow / 2 - 1) + numberOfConsonantsInRow % 2
            }
            numberOfConsonantsInRow = 0
            numberOfVowelsInRow++
        } else {
            if (numberOfVowelsInRow > 2) {
                result += (numberOfVowelsInRow / 2 - 1) + numberOfVowelsInRow % 2
            }
            numberOfVowelsInRow = 0
            numberOfConsonantsInRow++
        }
    }
    if (numberOfConsonantsInRow > 2) {
        result += (numberOfConsonantsInRow / 2 - 1) + numberOfConsonantsInRow % 2
    }
    if (numberOfVowelsInRow > 2) {
        result += (numberOfVowelsInRow / 2 - 1) + numberOfVowelsInRow % 2
    }

    println(result)
}