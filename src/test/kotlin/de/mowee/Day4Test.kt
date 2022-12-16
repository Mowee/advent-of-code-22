package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day4Test {

    @Test
    fun `get part one`() {
        // when
        val partOne = Day4().countPairsWhereOneRangeFullyContainsTheOther()

        // then
        assertThat(partOne).isEqualTo(2)
    }

    @Test
    fun `get part two`() {
        // when
        val partTwo = Day4().countPairsWhereTheRangesOverlap()

        // then
        assertThat(partTwo).isEqualTo(4)
    }
}