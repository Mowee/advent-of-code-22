package de.mowee

class Day3 : Day<Int>() {
    override val day: Int
        get() = 3

    override fun partOne(): Int {
        return input.lines().flatMap {
            getMatchingChars(listOf(it.dropLast(it.length / 2), it.drop(it.length / 2)))
        }.sumOf { getPriority(it) }
    }

    override fun partTwo(): Int {
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
