package de.mowee

import java.io.File

abstract class Day<T> {

    abstract val day: Int

    private val filename: String
        get() = lazy { "day$day.txt" }.value

    protected val input: String
        get() = getResourceAsText(filename)

    private fun getResourceAsText(path: String): String {
        val systemResource = ClassLoader.getSystemResource(path)
            ?: throw IllegalArgumentException("$filename does not exist!")
        return File(systemResource.file).readText()
    }

    abstract fun partOne(): T

    abstract fun partTwo(): T

}
