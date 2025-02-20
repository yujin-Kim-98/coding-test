package leetcode

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/97/dynamic-programming/572/
 * LeetCode - Top Interview Questions - Best Time to Buy and Sell Stock (dynamic programming)
 */
fun main() {

    // 5
//    val prices = intArrayOf(7, 1, 5, 3, 6, 4)

    val prices = intArrayOf(7, 6, 4, 3, 1)

    println(Solution().maxProfit(prices))

}

class Solution {

    fun maxProfit(prices: IntArray): Int {

        var min = prices[0]
        var maxProfit = 0

        for (i in 1 until prices.size) {

            when (min > prices[i]) {
                true -> min = prices[i]
                false -> {
                    if (maxProfit < prices[i] - min) {
                        maxProfit = prices[i] - min
                    }
                }
            }

        }

        return maxProfit
    }

}