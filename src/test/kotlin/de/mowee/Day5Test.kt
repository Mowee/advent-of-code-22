package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day5Test {

    @Test
    fun `get part one`() {
        // when
        val result = Day5().partOne()

        // then
        assertThat(result).isEqualTo("CMZ")
    }

    @Test
    fun `get part two`() {
        // when
        val result = Day5().partTwo()

        // then
        assertThat(result).isEqualTo("MCD")
    }
}