package day02

import readInput


fun main() {
    val testInput = readInput("day02/Day02")
    val extractedNumbersWithDirections = testInput.extractDirectionsWithNumbers()

    fun part1(input: List<List<String>>): Int {
        var horizontalDepth = 0
        var verticalDepth = 0
        input.map { pair ->
            val direction = pair[0]
            val number = pair[1].toInt()

            when (direction) {
                "forward" -> {
                    horizontalDepth += number
                }
                "up" -> {
                    verticalDepth -= number
                }
                "down" -> {
                    verticalDepth += number
                }
            }
        }


        return horizontalDepth * verticalDepth
    }

    fun part2(input: List<List<String>>): Int {
        var horizontalDepth = 0
        var verticalDepth = 0
        var aim = 0

        input.map { pair ->
            val direction = pair[0]
            val number = pair[1].toInt()

            when (direction) {
                "forward" -> {
                    horizontalDepth += number
                    verticalDepth += aim * number
                }
                "up" -> {
                    aim -= number
                }
                "down" -> {
                    aim += number
                }
            }
        }

        return horizontalDepth * verticalDepth
    }

    println(part1(extractedNumbersWithDirections))
    println(part2(extractedNumbersWithDirections))
}


fun List<String>.extractDirectionsWithNumbers(): List<List<String>> {
    return map {
        it.extractDirectionWithNumber()
    }
}

fun String.extractDirectionWithNumber(): List<String> {
    return split(" ")
}