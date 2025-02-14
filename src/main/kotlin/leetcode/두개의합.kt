package leetcode

/**
 * https://leetcode.com/problems/two-sum/description/
 * Easy - two sum (두개의합)
 */
fun main() {

    val nums = intArrayOf(2, 7, 11, 15)
    val target = 9

//    val nums = intArrayOf(3, 2, 4)
//    val target = 6

//    val nums = intArrayOf(3, 3)
//    val target = 6

    val result = Solution().twoSum(nums, target)

    result.map { print(it) }

}

class Solution {
    fun twoSum(nums: IntArray, target: Int): IntArray {

        for (i in 0 until nums.size) {
            val first = nums[i]

            for (j in i + 1 until nums.size) {
                val second = nums[j]

                if (first + second == target) {
                    return intArrayOf(i, j)
                }
            }

        }

        return intArrayOf()
    }
}