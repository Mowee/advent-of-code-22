package de.mowee

class Day3 : Day() {
    override val day: Int
        get() = 3

    fun getSumPart1(): Int {
        return input.lines().flatMap {
            getMatchingChars(listOf(it.dropLast(it.length / 2), it.drop(it.length / 2)))
        }.sumOf { getPriority(it) }
    }

    fun getSumPart2(): Int {
        return input.lines().windowed(3, 3).flatMap { getMatchingChars(it) }.sumOf { getPriority(it) }
    }

    private fun getMatchingChars(rows: List<String>): List<Char> {
        var buffer = rows.first()
        for (row in rows) {
            buffer = buffer.mapNotNull { it.takeIf { row.contains(it) } }.distinct().joinToString("")
        }
        return buffer.map { it }
    }

    private fun getPriority(char: Char): Int = when (char.code) {
        in 97..122 -> char.code - 96
        in 65..90 -> char.code - 38
        else -> throw IllegalStateException("Unexpected character $char")
    }

}

fun main() {
    val sum1 = Day3().getSumPart1()
    println(sum1)
    val sum2 = Day3().getSumPart2()
    println(sum2)
}