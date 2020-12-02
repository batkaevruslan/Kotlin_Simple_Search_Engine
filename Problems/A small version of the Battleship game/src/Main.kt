import java.util.Scanner

fun main(args: Array<String>) {
    val scanner = Scanner(System.`in`)

    val usedXs = IntArray(3)
    val usedYs = IntArray(3)
    usedXs[0] = scanner.nextInt()
    usedYs[0] = scanner.nextInt()
    usedXs[1] = scanner.nextInt()
    usedYs[1] = scanner.nextInt()
    usedXs[2] = scanner.nextInt()
    usedYs[2] = scanner.nextInt()
    printElements(usedXs)
    println()
    printElements(usedYs)
}

private fun printElements(usedElements: IntArray) {
    var firstXPrinted = false
    loop@ for (x in 1..5) {
        for (usedX in usedElements) {
            if (x == usedX) {
                continue@loop
            }
        }
        if (firstXPrinted) {
            print(" ")
        }
        print(x)
        firstXPrinted = true
    }
}