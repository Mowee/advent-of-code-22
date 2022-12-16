package de.mowee

import java.io.File

abstract class Day<T> {

    abstract val day: Int

    protected val input: String
        get() = getResourceAsText("day${day}.txt")

    private fun getResourceAsText(path: String): String {
        return File(ClassLoader.getSystemResource(path).file).readText()
    }

    abstract fun partOne(): T

    abstract fun partTwo(): T

}
