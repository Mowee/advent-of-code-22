package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day3Test{

    @Test
    fun `get sum one`() {
        // when
        val sum = Day3().getSumPart1()

        // then
        assertThat(sum).isEqualTo(157)
    }

    @Test
    fun `get sum part two`() {
        // when
        val sum = Day3().getSumPart2()

        // then
        assertThat(sum).isEqualTo(70)
    }
}