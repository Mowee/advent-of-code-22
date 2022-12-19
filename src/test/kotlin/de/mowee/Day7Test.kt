package de.mowee

import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class Day7Test {

    @Test
    fun partOne() {
        // when
        val result = Day7().partOne()

        // then
        assertThat(result).isEqualTo(95437)
    }

    @Test
    fun partTwo() {
        // when
        val result = Day7().partTwo()

        // then
        assertThat(result).isEqualTo(24933642)
    }
}