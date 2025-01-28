package algorithm.binarySearch

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*
import kotlin.math.abs

// 백준 2467 - 용액
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()

    val arr = readLine().split(" ").map { it.toInt() }.toIntArray()

    var startIndex = 0
    var endIndex = arr.size - 1

    var resultSum = arr[startIndex] + arr[endIndex]
    var leftValue = arr[startIndex]
    var rightValue = arr[endIndex]

    while (startIndex < endIndex) {

        val sum = arr[startIndex] + arr[endIndex]

        if (abs(sum) < abs(resultSum)) {
            resultSum = sum
            leftValue = arr[startIndex]
            rightValue = arr[endIndex]
        }

        when (sum > 0) {
            true -> endIndex--
            false -> startIndex++
        }

    }

    println("$leftValue $rightValue")

}