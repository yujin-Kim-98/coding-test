package leetcode

// LeetCode - 118. Pascal's Triangle
fun main() {

    val numRows = 5

//    val numRows = 2

    val result = Solution().generate(numRows)

    result.forEach {
        println(it.map { it })
    }

}

class Solution {
    fun generate(
        numRows: Int
    ): List<List<Int>> {

        val result = mutableListOf<List<Int>>()

        for (i in 0 until numRows) {
            when (i) {
                0 -> result.add(listOf(1))
                1 -> result.add(listOf(1, 1))
                else -> {
                    val list = mutableListOf<Int>()
                    for (j in 0 .. i) {
                        when (j == 0 || j == i) {
                            true -> list.add(1)
                            false -> list.add(result[i - 1][j - 1] + result[i - 1][j])
                        }
                    }
                    result.add(list)
                }
            }
        }

        return result

    }
}