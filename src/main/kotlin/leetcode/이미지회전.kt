package leetcode

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/770/
 * LeetCode - Top Interview Questions - Rotate Image
 */
fun main() {

    // ex1
//    val matrix = arrayOf(
//        intArrayOf(1, 2, 3),
//        intArrayOf(4, 5, 6),
//        intArrayOf(7, 8, 9),
//    )

    // ex2
//    val matrix = arrayOf(
//        intArrayOf(5, 1, 9, 11),
//        intArrayOf(2, 4, 8, 10),
//        intArrayOf(13, 3, 6, 7),
//        intArrayOf(15, 14, 12, 16),
//    )

    val matrix = arrayOf(
        intArrayOf(1, 2, 3),
        intArrayOf(4, 5, 6),
        intArrayOf(7, 8, 9),
    )

    val result = Solution().rotate(matrix)

    println(result)

}

class Solution {

    fun rotate(
        matrix: Array<IntArray>
    ): Unit {

        val result = Array(matrix.size) { IntArray(matrix[0].size) }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                result[j][matrix.size - 1 - i] = matrix[i][j]
            }
        }

        for (i in matrix.indices) {
            for (j in matrix[i].indices) {
                matrix[i][j] = result[i][j]
            }
        }
    }

}