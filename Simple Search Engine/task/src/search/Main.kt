package search

import java.io.File

fun main(args: Array<String>) {
    if (args[0] != "--data") {
        return
    }
    val allPeople = getAllPeople(args[1])
    val invertedIndexOfPeople = buildInvertedIndex(allPeople)
    while (true) {
        printMenu()
        when (readLine()!!.toInt()) {
            1 -> findPerson(allPeople, invertedIndexOfPeople as Map<String, MutableList<Int>>)
            2 -> printAllPeople(allPeople)
            0 -> return
            else -> println("Incorrect option! Try again.")
        }
    }
}

fun buildInvertedIndex(allPeople: List<String>): Any {
    val invertedIndex = mutableMapOf<String, MutableList<Int>>()
    for (i in allPeople.indices) {
        val words = allPeople[i].toLowerCase().split(" ")
        for (word in words) {
            if (invertedIndex.containsKey(word)) {
                invertedIndex[word]!!.add(i)
            } else {
                invertedIndex[word] = mutableListOf(i)
            }
        }
    }
    return invertedIndex
}

fun printAllPeople(allPeople: List<String>) {
    println("=== List of people ===")
    for (person in allPeople) {
        println(person)
    }
}

private fun findPerson(allPeople: List<String>, invertedIndexOfPeople: Map<String, MutableList<Int>>) {
    println("Select a matching strategy: ALL, ANY, NONE")
    val selectedStrategy = Strategy.valueOf(readLine()!!)

    println("Enter a name or email to search all suitable people.")
    val searchString = readLine()!!.toLowerCase()
    println()

    val foundPeople = findPerson(allPeople, invertedIndexOfPeople, searchString, selectedStrategy)
    if (foundPeople.isEmpty()) {
        println("No matching people found.")
    } else {
        println("${foundPeople.size} persons found:")
        for (person in foundPeople) {
            println(person)
        }
    }
}

private fun findPerson(allPeople: List<String>, invertedIndexOfPeople: Map<String, MutableList<Int>>, searchString: String, strategy: Strategy): List<String> {
    val tokens = searchString.split(" ")
    if (strategy == Strategy.NONE) {
        val excludedIndexes = HashSet<Int>()
        for (token in tokens) {
            excludedIndexes.addAll(invertedIndexOfPeople[token] ?: emptyList())
        }
        val foundPeople = mutableListOf<String>()
        for (index in allPeople.indices) {
            if (!excludedIndexes.contains(index)) {
                foundPeople.add(allPeople[index])
            }
        }
        return foundPeople.toList()
    }
    if (strategy == Strategy.ANY) {
        val includedIndices = HashSet<Int>()
        for (token in tokens) {
            includedIndices.addAll(invertedIndexOfPeople[token] ?: emptyList())
        }
        val foundPeople = mutableListOf<String>()
        for (index in allPeople.indices) {
            if (includedIndices.contains(index)) {
                foundPeople.add(allPeople[index])
            }
        }
        return foundPeople.toList()
    }

    val includedIndices = HashSet<Int>()
    for (token in tokens) {
        if (includedIndices.isEmpty()) {
            includedIndices.addAll(invertedIndexOfPeople[token] ?: emptyList())
        } else {
            includedIndices.intersect(invertedIndexOfPeople[token] ?: emptyList())
        }
    }
    val foundPeople = mutableListOf<String>()
    for (index in allPeople.indices) {
        if (includedIndices.contains(index)) {
            foundPeople.add(allPeople[index])
        }
    }
    return foundPeople.toList()
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

enum class Strategy {
    ALL, ANY, NONE
}
