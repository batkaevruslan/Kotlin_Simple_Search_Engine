package search

import java.io.File

fun main(args: Array<String>) {
    if (args[0] != "--data") {
        return
    }
    val allPeople = getAllPeople(args[1])
    while (true) {
        printMenu()
        when (readLine()!!.toInt()) {
            1 -> findPerson(allPeople)
            2 -> printAllPeople(allPeople)
            0 -> return
            else -> println("Incorrect option! Try again.")
        }
    }
}

fun printAllPeople(allPeople: List<String>) {
    println("=== List of people ===")
    for (person in allPeople) {
        println(person)
    }
}

private fun findPerson(allPeople: List<String>) {
    println("Enter the number of search queries:")
    println("Enter data to search people:")
    val searchString = readLine()!!
    println()

    println("Found people:")
    var anyOneFound = false
    for (y in allPeople.indices) {
        if (allPeople[y].contains(searchString, ignoreCase = true)) {
            println(allPeople[y])
            anyOneFound = true
        }
    }
    if (!anyOneFound) {
        println("No matching people found.")
    }
}

fun printMenu() {
    println()
    println("=== Menu ===\n" +
            "1. Find a person\n" +
            "2. Print all people\n" +
            "0. Exit")
}

private fun getAllPeople(pathToFile: String): List<String> {
    return File(pathToFile).readLines()
}
