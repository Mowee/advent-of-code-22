package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day2Test {

    @Test
    fun `get total score part 1`() {
        // when
        val score = Day2().partOne()

        // then
        assertThat(score).isEqualTo(15)
    }

    @Test
    fun `get total score part 2`() {
        // when
        val score = Day2().partTwo()

        // then
        assertThat(score).isEqualTo(12)
    }

}