package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 * LeetCode - Top Interview Questions - Single Number
 *
 * 1.
 * Runtime: 141 ms
 * Memory Usage: 40.4 MB
 *
 * 2.
 *
 */
fun main() {

//    val nums = intArrayOf(2, 2, 1)

    val nums = intArrayOf(4, 1, 2, 1, 2)

//    val nums = intArrayOf(1)

    println(Solution().singleNumber(nums))

}

class Solution {

    fun singleNumber(nums: IntArray): Int {

        return nums.reduce { acc, num -> acc xor num }

    }

}