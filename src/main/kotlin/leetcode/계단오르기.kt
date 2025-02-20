package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/569/
 * LeetCode - Top Interview Questions - Climbing Stairs (dynamic programming)
 */
fun main() {

    val n = 2

//    val n = 3

    val result = Solution().climbStairs(n)

    println(result)

}

class Solution {

    fun climbStairs(n: Int): Int {

        return when (n <= 2) {
            true -> n
            false -> {
                val dp = IntArray(n + 1)

                dp[1] = 1
                dp[2] = 2

                for (i in 3 .. n) {
                    dp[i] = dp[i - 1] + dp[i - 2]
                }

                dp[n]
            }
        }

    }

}
