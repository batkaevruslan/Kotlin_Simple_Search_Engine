import java.util.*

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)
    var position = 1
    var max:Int? = null
    var positionOfMax = 1
    while (scanner.hasNext()) {
        val current = scanner.nextInt()
        if (max == null || max < current) {
            max = current
            positionOfMax = position
        }
        position++
    }
    println("$max $positionOfMax")
}