package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day1Test {

    @Test
    fun `returns a list of totals`() {
        // when
        val listOfTotals = Day1().getTotals()

        // then
        assertThat(listOfTotals).isEqualTo(listOf(6000, 4000, 11000, 24000, 10000))
    }

    @Test
    fun `returns the elf carrying the most calories`() {
        // when
        val calories = Day1().getMostCalories()

        // then
        assertThat(calories).isEqualTo(24000)
    }

    @Test
    fun `get top three elfs carying the most calories`() {
        // when
        val calories  = Day1().getTopThreeCalories()

        // then
        assertThat(calories).isEqualTo(45000)
    }
}