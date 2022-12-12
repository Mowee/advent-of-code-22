package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `get total score part 1`() {
        // when
        val score = Day2().getTotalScorePartOne()

        // then
        assertThat(score).isEqualTo(15)
    }

    @Test
    fun `get total score part 2`() {
        // when
        val score = Day2().getTotalScorePartTwo()

        // then
        assertThat(score).isEqualTo(12)
    }

}