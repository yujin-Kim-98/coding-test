package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/98/design/670/
 * LeetCode - Top Interview Questions - Shuffle an Array (Design)
 */
fun main() {

    val nums = intArrayOf(1, 2, 3)

    val solution = Solution(nums)

    val shuffle1 = solution.shuffle()
    val reset = solution.reset()
    val shuffle2 = solution.shuffle()

}

class Solution(
    nums: IntArray
) {

    private val originNums = nums.copyOf()
    private var shuffleNums = nums

    // 배열을 원래 구성으로 재설정하고 반환
    fun reset(): IntArray {
        return originNums
    }

    // 배열의 무작위 셔플링을 반환
    fun shuffle(): IntArray {
        return shuffleNums
            .apply { shuffle() }
    }

}