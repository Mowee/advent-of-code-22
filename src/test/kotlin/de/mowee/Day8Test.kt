package de.mowee

import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test

class Day8Test {

    @Test
    fun partOne() {
        // when
        val result = Day8().partOne()

        // then
        Assertions.assertThat(result).isEqualTo(21)
    }

    @Test
    fun partTwo() {
        // when
        val result = Day8().partTwo()

        // then
        Assertions.assertThat(result).isEqualTo(8)
    }

}