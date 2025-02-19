package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/646/
 * LeetCode - Top Interview Questions - Contains Duplicate
 *
 * 1.
 * Runtime: 3902 ms
 * Memory Usage: 52.3 MB
 *
 * 2.
 * Runtime: 16 ms
 * Memory Usage: 51.3 MB
 *
 */
fun main() {

    val nums = intArrayOf(1, 2, 3, 1)

//    val nums = intArrayOf(1, 2, 3, 4)

//    val nums = intArrayOf(1, 1, 1, 3, 3, 4, 3, 2, 4, 2)

    println(Solution().containsDuplicate(nums))

}

class Solution {

    fun containsDuplicate(nums: IntArray): Boolean {

        val set = mutableSetOf<Int>()

        nums.forEach {
            if (!set.add(it)) {
                return true
            }
        }

        return false

    }

}