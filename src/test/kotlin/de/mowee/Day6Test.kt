package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day6Test {

    @Test
    fun partOne() {
        // when
        val partOne = Day6().partOne()

        // then
        assertThat(partOne).isEqualTo(7)
    }

    @Test
    fun `part one multilines`() {
        // when
        val partOne = Day6().countCharactersBeforeUniqueMarkerIsDetected(4)

        // then
        assertThat(partOne).containsAll(listOf(7, 5, 6, 10, 11))
    }

    @Test
    fun partTwo() {
        // when
        val partTwo = Day6().partTwo()

        // then
        assertThat(partTwo).isEqualTo(19)
    }

    @Test
    fun `part two multilines`() {
        // when
        val partTwo = Day6().countCharactersBeforeUniqueMarkerIsDetected(14)

        // then
        assertThat(partTwo).containsAll(listOf(19, 23, 23, 29, 26))
    }
}