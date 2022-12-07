package de.mowee

class Day1 : Day() {

    override val day = 1

    fun getTotals(): List<Int> {
        return input.split("\n\n").map { group ->
            group.split("\n").sumOf { it.toInt() }
        }
    }

    fun getMostCalories(): Int {
        return getTotals().max()
    }

    fun getTopThreeCalories(): Int {
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

fun main() {
    val mostCalories = Day1().getMostCalories()
    println(mostCalories)

    val topThreeCalories = Day1().getTopThreeCalories()
    println(topThreeCalories)
}