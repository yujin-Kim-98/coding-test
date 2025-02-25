package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/576/
 * LeetCode - Top Interview Questions - House Robber (dynamic programming)
 */
fun main() {

//    val nums = intArrayOf(1, 2, 3, 1)

    val nums = intArrayOf(2, 7, 9, 3, 1)

    println(Solution().rob(nums))

}

class Solution {

    fun rob(nums: IntArray): Int {
        var prev1 = nums[0]
        var prev2 = 0

        for (i in 1 until nums.size) {
            val current = maxOf(prev1, nums[i] + prev2)
            prev2 = prev1
            prev1 = current
        }

        return prev1
    }

}