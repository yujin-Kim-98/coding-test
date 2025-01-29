package algorithm.DFSBFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

private var riceCakes = emptyArray<MutableList<Int>>()
private var result = intArrayOf()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val N = readLine().toInt()

    riceCakes = Array(N) { mutableListOf() }

    for (i in 0 until N) {
        val st = StringTokenizer(readLine())

        val count = st.nextToken().toInt()
        repeat(count) {
            riceCakes[i].add(st.nextToken().toInt())
        }
    }

    result = IntArray(N)

    if (!dfs(0, 0, N)) {
        println("-1")
    }

}

fun dfs(
    day: Int,
    prev: Int,
    finalDay: Int
): Boolean {

    if (day == finalDay) {
        result.forEach { println(it) }
        return true
    }

    riceCakes[day].forEach { riceCake ->
        if (riceCake != prev) {
            result.set(day, riceCake)
            if (dfs(day + 1, riceCake, finalDay)) return true
        }
    }

    return false
}