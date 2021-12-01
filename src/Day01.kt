fun main() {
    fun part1(input: List<String>): Int =
            input
                    .map { it.toInt() }
                    .countIncreases()

    fun part2(input: List<String>): Int =
           input
                   .map { it.toInt() }
                   .countDepthIncreases()


    // test if implementation meets criteria from the description, like:
    val testInput = readInput("Day01")
    val inputIncreases = part1(testInput)
    val inputDepthIncreases = part2(testInput)


    val input = readInput("Day01")
    println("Part 1: ${part1(input)}")
    check(inputIncreases == 1228)
    println("Part 2: ${part2(input)}")
    check(inputDepthIncreases == 1257)
}

fun List<Int>.countIncreases(): Int {
    return mapIndexed { index, value ->
        if (index != 0 && get(index - 1) < value) {
            1
        } else {
            0
        }
    }.sum()
}


fun List<Int>.countDepthIncreases(): Int {
    return windowed(3)
            .map { it.sum() }
            .windowed(2)
            .count {
                (a, b) -> a < b
            }
}
