package de.mowee

class Day2 : Day<Int>() {

    enum class Item(private val beats: Int) {
        ROCK(2),
        PAPER(0),
        SCISSOR(1);

        fun winsAgainst(item: Item): Boolean {
            return beats == item.ordinal
        }

        fun loosesAgainst(item: Item): Boolean {
            if (this == item) {
                return false
            }

            return !winsAgainst(item)
        }

        fun winsAgainst(): Item =
            iterateValues(::winsAgainst, "It's impossible to find a item that wins against $this.")

        fun loosesAgainst(): Item =
            iterateValues(::loosesAgainst, "It's impossible to find a item that looses against $this.")

        private fun iterateValues(validate: (item: Item) -> Boolean, errorMessage: String): Item {
            for (value in values()) {
                if (validate(value)) {
                    return value
                }
            }
            throw IllegalStateException(errorMessage)
        }
    }

    enum class StrategyGuide {
        X, Y, Z
    }

    enum class OpponentsMove {
        A, B, C
    }

    override val day: Int
        get() = 2

    override fun partOne(): Int {
        return input.trim().lines().sumOf {
            val strategyGuide = it.split(" ")
            val opponentsMove = getOpponentsMove(strategyGuide.first())
            val myMove = mapStrategyGuideToMyMove(strategyGuide.last())

            getPointsForItem(myMove) + getPointsForMove(myMove, opponentsMove)
        }
    }

    override fun partTwo(): Int {
        return input.trim().lines().sumOf {
            val strategyGuide = it.split(" ")
            val opponentsMove = getOpponentsMove(strategyGuide.first())
            val myMove = mapStrategyGuideToRoundEnd(strategyGuide.last(), opponentsMove)

            getPointsForItem(myMove) + getPointsForMove(myMove, opponentsMove)
        }
    }

    private fun getOpponentsMove(code: String): Item {
        return when (OpponentsMove.valueOf(code)) {
            OpponentsMove.A -> Item.ROCK
            OpponentsMove.B -> Item.PAPER
            OpponentsMove.C -> Item.SCISSOR
        }
    }

    private fun mapStrategyGuideToMyMove(code: String): Item {
        return when (StrategyGuide.valueOf(code)) {
            StrategyGuide.X -> Item.ROCK
            StrategyGuide.Y -> Item.PAPER
            StrategyGuide.Z -> Item.SCISSOR
        }
    }

    private fun mapStrategyGuideToRoundEnd(code: String, opponentsMove: Item): Item {
        return when (StrategyGuide.valueOf(code)) {
            StrategyGuide.X -> opponentsMove.winsAgainst() // Loose
            StrategyGuide.Y -> opponentsMove // Draw
            StrategyGuide.Z -> opponentsMove.loosesAgainst() // Win
        }
    }

    private fun getPointsForItem(item: Item): Int {
        return when (item) {
            Item.ROCK -> 1
            Item.PAPER -> 2
            Item.SCISSOR -> 3
        }
    }

    private fun getPointsForMove(myMove: Item, opponentsMove: Item): Int {
        return if (myMove.winsAgainst(opponentsMove)) {
            6
        } else if (myMove.loosesAgainst(opponentsMove)) {
            0
        } else {
            3
        }
    }

}
