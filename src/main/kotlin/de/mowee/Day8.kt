package de.mowee

class Day8 : Day<Int>() {
    override val day: Int
        get() = 8

    override fun partOne(): Int {
        val matrix = getMatrix()
        var count = 0
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                if (matrix.left(x, y).none { tree -> tree >= matrix.getTree(x, y) } ||
                    matrix.right(x, y).none { tree -> tree >= matrix.getTree(x, y) } ||
                    matrix.up(x, y).none { tree -> tree >= matrix.getTree(x, y) } ||
                    matrix.down(x, y).none { tree -> tree >= matrix.getTree(x, y) }
                ) {
                    count++
                }
            }
        }
        return count
    }

    override fun partTwo(): Int {
        val matrix = getMatrix()
        val treeDistance = mutableListOf<Int>()
        for (y in matrix.indices) {
            for (x in matrix[y].indices) {
                val up = matrix.up(x, y).getDistanceTo(matrix.getTree(x, y))
                val left = matrix.left(x, y).getDistanceTo(matrix.getTree(x, y))
                val right = matrix.right(x, y).getDistanceTo(matrix.getTree(x, y))
                val down = matrix.down(x, y).getDistanceTo(matrix.getTree(x, y))
                treeDistance.add(up * left * right * down)
            }
        }

        return treeDistance.max()
    }

    private fun List<Int>.getDistanceTo(tree: Int): Int {
        var count = 0
        for (i in this) {
            count++
            if (i >= tree) {
                break
            }
        }
        return count
    }

    private fun getMatrix(): List<List<Char>> =
        input.trim().lines().map { y -> y.map { x -> x } }

    private fun List<List<Char>>.getTree(x: Int, y: Int): Int =
        this[y][x].digitToInt()

    private fun List<List<Char>>.left(x: Int, y: Int): List<Int> =
        (0 until x).map { getTree(it, y) }.asReversed()

    private fun List<List<Char>>.right(x: Int, y: Int): List<Int> =
        (x + 1..this[y].indices.last).map { getTree(it, y) }

    private fun List<List<Char>>.up(x: Int, y: Int): List<Int> =
        (0 until y).map { getTree(x, it) }.asReversed()

    private fun List<List<Char>>.down(x: Int, y: Int): List<Int> =
        (y + 1..this.indices.last).map { getTree(x, it) }
}
