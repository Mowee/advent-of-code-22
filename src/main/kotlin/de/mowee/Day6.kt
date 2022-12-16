package de.mowee

class Day6 : Day<Int>() {
    override val day: Int
        get() = 6

    override fun partOne(): Int {
        return countCharactersBeforeUniqueMarkerIsDetected(4).first()
    }

    override fun partTwo(): Int {
        return countCharactersBeforeUniqueMarkerIsDetected(14).first()
    }

    fun countCharactersBeforeUniqueMarkerIsDetected(numberOfDistinctCharacters: Int): List<Int> {
        return input.lines().map { line ->
            line.windowed(numberOfDistinctCharacters)
                .map { window -> window.map { it }.distinct() }
                .indexOfFirst { it.count() == numberOfDistinctCharacters }
                .let { it + numberOfDistinctCharacters }
        }
    }
}