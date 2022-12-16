package de.mowee

class Day1 : Day<Int>() {

    override val day = 1

    fun getTotals(): List<Int> {
        return input.trim().split("\n\n").map { group ->
            group.split("\n").sumOf { it.toInt() }
        }
    }

    override fun partOne(): Int {
        return getTotals().max()
    }

    override fun partTwo(): Int {
        val top = 3
        var sum = 0

        for ((index, value) in getTotals().sortedDescending().withIndex()) {
            sum += value
            if (index >= top - 1) {
                break
            }
        }

        return sum
    }

}
