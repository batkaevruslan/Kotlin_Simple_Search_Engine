fun main() {
    val words = mutableMapOf<String, Int>()
    while (true) {
        val word = readLine()!!
        if (word == "stop") {
            break
        }
        if (words.containsKey(word)) {
            words[word] = words[word]!! + 1
        } else {
            words[word] = 1
        }
    }
    if (words.isEmpty()) {
        print(null)
    } else {
        val maxValue = words.maxOf { entry -> entry.value }
        val mostFrequentWord = words.entries.first { entry -> entry.value == maxValue }
        print(mostFrequentWord.key)
    }
}