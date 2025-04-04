package leetcode

/**
 * LeetCode - 454. 4Sum II (Medium)
 * https://leetcode.com/problems/4sum-ii/description/
 */
fun main() {

    val nums1 = intArrayOf(1, 2)
    val nums2 = intArrayOf(-2, -1)
    val nums3 = intArrayOf(-1, 2)
    val nums4 = intArrayOf(0, 2)

    val result = Solution().fourSumCount(nums1, nums2, nums3, nums4)

    println("result: $result")

}

class Solution {

    fun fourSumCount(
        nums1: IntArray,
        nums2: IntArray,
        nums3: IntArray,
        nums4: IntArray
    ): Int {

        val map = mutableMapOf<Int, Int>()

        nums1.forEach { num1 ->
            nums2.forEach { num2 ->
                map[num1 + num2] = map.getOrDefault(num1 + num2, 0) + 1
            }
        }

        var result = 0

        nums3.forEach { num3 ->
            nums4.forEach { num4 ->
                val target = -(num3 + num4)

                result += map[target] ?: 0
            }
        }

        return result
    }

}