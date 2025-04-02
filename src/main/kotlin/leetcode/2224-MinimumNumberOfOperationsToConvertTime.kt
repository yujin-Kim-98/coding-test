package leetcode

import java.time.Duration
import java.time.LocalTime
import java.time.format.DateTimeFormatter

/**
 * LeetCode - 2224-MinimumNumberOfOperationsToConvertTime (Easy)
 * https://leetcode.com/problems/minimum-number-of-operations-to-convert-time/description/?envType=problem-list-v2&envId=greedy
 */
fun main() {

    val current = "11:00"
    val correct = "11:50"

    val result = Solution().convertTime(current, correct)

    println("result : $result")

}

class Solution {
    fun convertTime(
        current: String,
        correct: String
    ): Int {

        val formatter = DateTimeFormatter.ofPattern("HH:mm")

        val currentTime = LocalTime.parse(current, formatter)
        val correctTime = LocalTime.parse(correct, formatter)

        var duration = Duration.between(currentTime, correctTime).toMinutes()

        val ops = listOf(60, 15, 5, 1)
        var result = 0

        for (op in ops) {
            result += (duration / op).toInt()
            duration %= op
        }

        return result
    }
}