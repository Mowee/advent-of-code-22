package de.mowee

class Day7 : Day<Long>() {

    override val day: Int
        get() = 7

    class Filesystem {

        val root: Directory = Directory("/", null)

        private var workingDirectory: Directory = root

        fun changeDirectory(name: String?) {
            if (name == null) {
                return
            }

            workingDirectory = when (name) {
                "/" -> root
                ".." -> workingDirectory.parent as Directory?
                    ?: throw IllegalStateException(workingDirectory.name + "has no parent")

                else -> getChildDirectory(name)
            }
        }

        fun addFile(filename: String, size: Long) {
            workingDirectory.files.add(File(size, filename, workingDirectory))
        }

        fun makeDirectory(name: String): Directory {
            val newDirectory = Directory(name, workingDirectory)
            workingDirectory.subDirectories.add(newDirectory)
            return newDirectory
        }

        private fun getChildDirectory(name: String): Directory {
            return workingDirectory.subDirectories.firstOrNull { it.name == name }
                ?: makeDirectory(name)
        }
    }

    class Directory(
        name: String,
        parent: Directory?,
        val subDirectories: MutableList<Directory> = mutableListOf(),
        val files: MutableList<File> = mutableListOf(),
    ) : Node(name, parent) {
        val folderSize: Long
            get() = files.sumOf { it.size } + subDirectories.sumOf { it.folderSize }

        val hasSubDirectories: Boolean
            get() = subDirectories.isNotEmpty()
    }

    class File(
        val size: Long,
        name: String,
        parent: Directory,
    ) : Node(name, parent)

    open class Node(
        val name: String,
        val parent: Node?,
    )

    override fun partOne(): Long {
        return mapInputToFilesystem().root.subDirectories
            .mapDirectorySize(mutableListOf())
            .filter { it.second <= 100000 }
            .sumOf { it.second }
    }

    override fun partTwo(): Long {
        val filesystem = mapInputToFilesystem()
        val unusedSpace = 70000000 - filesystem.root.folderSize
        val requiredSpace = 30000000 - unusedSpace
        return filesystem.root.subDirectories
            .mapDirectorySize(mutableListOf())
            .sortedBy { it.second }
            .first { it.second >= requiredSpace }
            .second
    }

    private fun mapInputToFilesystem(): Filesystem {
        val filesystem = Filesystem()
        var lastCommand: String? = null

        input.trim().lines().forEach { line ->
            if (line.isCommand()) {
                lastCommand = line.getCommand()
            }

            if (line.getCommand() == "cd") {
                filesystem.changeDirectory(line.getCdTarget())
            }

            if (lastCommand == "ls" && !line.isCommand()) {
                val split = line.split(" ")
                if (split.first() == "dir") {
                    filesystem.makeDirectory(split.last())
                } else {
                    filesystem.addFile(split.last(), split.first().toLong())
                }
            }
        }
        return filesystem
    }

    private fun MutableList<Directory>.mapDirectorySize(
        destination: MutableList<Pair<String, Long>>
    ): List<Pair<String, Long>> {
        forEach {
            if (it.hasSubDirectories) {
                it.subDirectories.mapDirectorySize(destination)
            }
            destination.add(getSizeOfDirectory(it))
        }

        return destination.toList()
    }

    private fun getSizeOfDirectory(directory: Directory): Pair<String, Long> {
        return directory.name to directory.folderSize
    }

    private fun String.isCommand(): Boolean = startsWith("$ ")

    private fun String.getCommand(): String? = takeIf { isCommand() }?.let { split(" ")[1] }

    private fun String.getCdTarget(): String? = takeIf { getCommand() == "cd" }?.let { split(" ")[2] }

}
