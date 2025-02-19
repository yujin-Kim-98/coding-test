package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 * LeetCode - Top Interview Questions - Rotate Array
 */
fun main() {

    val nums = intArrayOf(1, 2, 3, 4, 5, 6, 7)
    val k = 3

//    val nums = intArrayOf(-1, -100, 3, 99)
//    val k = 2

    Solution().rotate(nums, k)

}

class Solution {

    fun rotate(nums: IntArray, k: Int): Unit {

        val result = IntArray(nums.size)

        for (i in 0 until nums.size) {
            if (i + k < nums.size) {
                result[i + k] = nums[i]
            } else {
                result[(i + k) % nums.size] = nums[i]
            }
        }

        result.copyInto(nums)
    }

}