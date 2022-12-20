package de.mowee

fun main() {
    val days = listOf(
        Day1(),
        Day2(),
        Day3(),
        Day4(),
        Day5(),
        Day6(),
        Day7(),
        Day8(),
    )

    days.forEach { day ->
        println("========= Tag ${day.day} =========")
        println("Part1: ${day.partOne()}")
        println("Part2: ${day.partTwo()}")
        println()
    }
}