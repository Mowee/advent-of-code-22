package de.mowee

import java.io.File

abstract class Day {

    abstract val day: Int

    protected val input: String
        get() = getResourceAsText("day${day}.txt").trim()

    private fun getResourceAsText(path: String): String {
        return File(ClassLoader.getSystemResource(path).file).readText()
    }

}
