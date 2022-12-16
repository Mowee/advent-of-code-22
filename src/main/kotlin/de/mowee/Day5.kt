package de.mowee

class Day5 : Day<String>() {
    override val day: Int
        get() = 5

    override fun partOne(): String {
        return handleInstruction { instruction, stacks ->
            val (numberOfMoves, from, to) = extractInformationFromInstruction(instruction)
            for (i in 0 until numberOfMoves) {
                stacks[to].add(stacks[from].removeLast())
            }
        }
    }

    override fun partTwo(): String {
        return handleInstruction { instruction, stacks ->
            val (numberOfMoves, from, to) = extractInformationFromInstruction(instruction)
            val buffer = mutableListOf<Char>()
            for (i in 0 until numberOfMoves) {
                buffer.add(stacks[from].removeLast())
            }
            stacks[to].addAll(buffer.reversed())
        }
    }

    private fun handleInstruction(handling: (instruction : String, stacks: List<MutableList<Char>>) -> Unit) : String {
        val (stacks, instructions) = input.split("\n\n").let { input ->
            extractStack(input) to input.last().trim().lines()
        }

        instructions.forEach { instruction ->
            handling(instruction, stacks)
        }

        return stacks.map { it.last() }.joinToString("")
    }

    private fun extractStack(input: List<String>): List<MutableList<Char>> {
        return input.first().lines().map { row -> row.map { char -> char } }.reversed().let { rows ->
            rows.first().mapIndexedNotNull { digitIndex, digit ->
                digit.takeIf { digit.isDigit() }?.let { _ ->
                    rows.drop(1).flatMap { row ->
                        row.mapIndexedNotNull { charIndex, char ->
                            char.takeIf { charIndex == digitIndex }?.takeIf { it.isLetter() }
                        }
                    }
                }?.toMutableList()
            }
        }
    }

    private fun extractInformationFromInstruction(string: String): Triple<Int, Int, Int> {
        val regex = "^move (\\d+) from (\\d+) to (\\d+)\$".toRegex()
        val matches = regex.matchEntire(string)
        if (!regex.matches(string) || matches == null) {
            throw IllegalArgumentException("Unexpected input. '$string' does not match regex.")
        }

        return matches.let {
            val (numberOfMoves, from, to) = it.destructured
            Triple(numberOfMoves.toInt(), from.toInt() - 1, to.toInt() - 1)
        }
    }


}