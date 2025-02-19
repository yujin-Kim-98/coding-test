package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 * LeetCode - Top Interview Questions - Contains Duplicate
 */
fun main() {

//    val nums = intArrayOf(1, 2, 3, 1)

    val nums = intArrayOf(1, 2, 3, 4)

//    val nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)

    println(Solution().containsDuplicate(nums))

}

class Solution {

    fun containsDuplicate(nums: IntArray): Boolean {

        nums.forEach { num ->
            val cnt = nums.count { it == num }
            if (cnt > 1) {
                return true
            }
        }

        return false

    }

}