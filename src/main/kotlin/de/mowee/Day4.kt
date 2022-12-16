package de.mowee

class Day4 : Day<Int>() {
    override val day: Int
        get() = 4

    override fun partOne(): Int {
        return countPairsWithinRangesWhere { previous, current -> doesOneRangeFullyContainsTheOther(previous, current) }
    }

    override fun partTwo(): Int {
        return countPairsWithinRangesWhere { previous, current -> doTheRangesOverlap(previous, current) }
    }

    private fun countPairsWithinRangesWhere(condition: (previous: IntRange, current: IntRange) -> Boolean): Int {
        return input.lines().map { pair ->
            pair.split(",").map { range ->
                val split = range.split("-")
                IntRange(split.first().toInt(), split.last().toInt())
            }
        }.map { intRanges ->
            var contains = false
            loop@ for (i in 1 until intRanges.size) {
                contains = condition(intRanges[i - 1], intRanges[i])
                if (contains)
                    break@loop
            }

            contains
        }.sumOf { contains ->
            (contains.takeIf { it }?.let { 1 } ?: 0).toInt()
        }
    }

    private fun doesOneRangeFullyContainsTheOther(previous: IntRange, current: IntRange): Boolean {
        return (previous.contains(current.first) && previous.contains(current.last)) ||
                (current.contains(previous.first) && current.contains(previous.last))
    }

    private fun doTheRangesOverlap(previous: IntRange, current: IntRange): Boolean {
        return (previous.contains(current.first) || previous.contains(current.last)) ||
                (current.contains(previous.first) || current.contains(previous.last))
    }
}
