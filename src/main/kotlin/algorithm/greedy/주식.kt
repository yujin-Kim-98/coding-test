package algorithm.greedy

import java.io.BufferedReader
import java.io.InputStreamReader

// 백준 11047
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()

    var resultString = StringBuilder()

    repeat(T) {
        val day = readLine().toInt()
        val prices = readLine().split(" ").map { it.toInt() }.toMutableList()

        var maxPrice = 0L
        var result = 0L

        for (i in day - 1 downTo 0) {
            if (prices[i] > maxPrice) {
                maxPrice = prices[i].toLong()
            } else {
                result += (maxPrice - prices[i])
            }
        }

        resultString.append(result).append("\n")

    }

    print(resultString)

}