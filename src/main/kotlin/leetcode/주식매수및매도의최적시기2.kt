package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/92/array/564/
 * LeetCode - Top Interview Questions - Best Time to Buy and Sell Stock II
 */
fun main() {

//    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

//    val prices = intArrayOf(1, 2, 3, 4, 5)

    val prices = intArrayOf(7, 6, 4, 3, 1)

    val result = Solution().maxProfit(prices)

    println(result)

}

class Solution {

    fun maxProfit(prices: IntArray): Int {

        var prev = prices[0]
        var result = 0

        for (i in 1 until prices.size) {
            if (prices[i] > prev) {
                result += prices[i] - prev
            }
            prev = prices[i]
        }

        return result
    }

}