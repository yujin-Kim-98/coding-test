package algorithm

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder
import java.util.*

// 백준 7795 - 먹을 것인가 먹힐 것인가
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()
    val result = IntArray(T)

    for (i in 0 until T) {
        val st = StringTokenizer(readLine())

        val N = st.nextToken().toInt()
        val M = st.nextToken().toInt()

        val A = readLine().split(" ").map { it.toInt() }.toIntArray()
        val B = readLine().split(" ").map { it.toInt() }.toIntArray()
        B.sort()

        var count = 0
        A.forEach {
            count += lowerBound(B, it)
        }

        result[i] = count
    }

    val sb = StringBuilder()
    result.forEach { sb.append(it).append("\n") }
    print(sb.toString())
}


fun lowerBound(
    array: IntArray,
    target: Int
): Int {
    var left = 0
    var right = array.size

    while (left < right) {
        val mid = (left + right) / 2
        if (array[mid] < target) {
            left = mid + 1
        } else {
            right = mid
        }
    }
    return left
}