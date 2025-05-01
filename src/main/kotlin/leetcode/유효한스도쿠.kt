package leetcode

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/769/
 * LeetCode - Top Interview Questions - Valid Sudoku (Array)
 */
fun main() {

    // ex1
//    val board = arrayOf(
//        charArrayOf('5','3','.','.','7','.','.','.','.'),
//        charArrayOf('6','.','.','1','9','5','.','.','.'),
//        charArrayOf('.','9','8','.','.','.','.','6','.'),
//        charArrayOf('8','.','.','.','6','.','.','.','3'),
//        charArrayOf('4','.','.','8','.','3','.','.','1'),
//        charArrayOf('7','.','.','.','2','.','.','.','6'),
//        charArrayOf('.','6','.','.','.','.','2','8','.'),
//        charArrayOf('.','.','.','4','1','9','.','.','5'),
//        charArrayOf('.','.','.','.','8','.','.','7','9')
//    )


    // ex2
//    val board = arrayOf(
//        charArrayOf('8','3','.','.','7','.','.','.','.'),
//        charArrayOf('6','.','.','1','9','5','.','.','.'),
//        charArrayOf('.','9','8','.','.','.','.','6','.'),
//        charArrayOf('8','.','.','.','6','.','.','.','3'),
//        charArrayOf('4','.','.','8','.','3','.','.','1'),
//        charArrayOf('7','.','.','.','2','.','.','.','6'),
//        charArrayOf('.','6','.','.','.','.','2','8','.'),
//        charArrayOf('.','.','.','4','1','9','.','.','5'),
//        charArrayOf('.','.','.','.','8','.','.','7','9')
//    )

    val board = arrayOf(
        charArrayOf('4','.','.','.','5','.','.','1','.'),
        charArrayOf('.','4','.','3','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','3','.','.','1'),
        charArrayOf('8','.','.','.','.','.','.','2','.'),
        charArrayOf('.','.','2','.','7','.','.','.','.'),
        charArrayOf('.','1','5','.','.','.','.','.','.'),
        charArrayOf('.','.','.','.','.','2','.','.','.'),
        charArrayOf('.','2','.','9','.','.','.','.','.'),
        charArrayOf('.','.','4','.','.','.','.','.','.')
    )

    val result = Solution().isValidSudoku(board)

    println("result : $result")

}

class Solution {

    fun isValidSudoku(
        board: Array<CharArray>
    ): Boolean {

        val rows = Array(board.size + 1) { BooleanArray(board.size + 1) }
        val cols = Array(board.size + 1) { BooleanArray(board.size + 1) }
        val boxes = Array(board.size + 1) { BooleanArray(board.size + 1) }

        for (i in board.indices) {
            for (j in board[i].indices) {
                val ch = board[i][j]
                when (ch == '.') {
                    true -> continue
                    false -> {
                        val num = ch.digitToInt()
                        val boxIndex = (i / 3) * 3 + (j / 3)

                        if (rows[i][num] || cols[j][num] || boxes[boxIndex][num]) {
                            return false
                        }

                        rows[i][num] = true
                        cols[j][num] = true
                        boxes[boxIndex][num] = true
                    }
                }

            }
        }
        return true
    }

}