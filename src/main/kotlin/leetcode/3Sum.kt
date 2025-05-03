package leetcode

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-medium/103/array-and-strings/776/
 * LeetCode - 3 Sum (Top Interview Questions)
 */
fun main() {

    // ex1
    val nums = intArrayOf(-1, 0, 1, 2, -1, -4)

    // ex2
//    val nums = intArrayOf(0, 1, 1)

    // ex3
//    val nums = intArrayOf(0, 0, 0)

    val result = Solution().threeSum(nums)

    println(result)

}

class Solution {

    fun threeSum(
        nums: IntArray
    ): List<List<Int>> {

        val result = mutableSetOf<List<Int>>()

        nums.sort()
        for (i in nums.indices) {
            var left = i + 1
            var right = nums.lastIndex

            while (left < right) {
                val sum = nums[i] + nums[left] + nums[right]

                when {
                    sum == 0 -> {
                        result.add(listOf(nums[i], nums[left], nums[right]))
                        left++
                        right--
                    }
                    sum < 0 -> left++
                    else -> right--
                }
            }
        }

        return result.map { it.toList() }
    }

}