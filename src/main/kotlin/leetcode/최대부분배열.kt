package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/566/
 * LeetCode - Top Interview Questions - Maximum Subarray (dynamic programming)
 */
fun main() {

    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)

//    val nums = intArrayOf(1)

//    val nums = intArrayOf(5, 4, -1, 7, 8)

    println(Solution().maxSubArray(nums))

}

class Solution {

    fun maxSubArray(nums: IntArray): Int {

        var currentSum = nums[0]
        var maxSum = nums[0]

        for (i in 1 until nums.size) {
            currentSum = maxOf(nums[i], currentSum + nums[i])
            maxSum = maxOf(maxSum, currentSum)
        }

        return maxSum
    }

}