package algorithm.greedy

import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.StringBuilder

// 백준 1946 신입사원
fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val T = readLine().toInt()

    val sb = StringBuilder()

    repeat(T) {
        val N = readLine().toInt()

        val rankingList = mutableListOf<Pair<Int, Int>>()

        for (i in 0 until N) {
            val ranking = readLine()
            val first = ranking.split(" ")[0].toInt()
            val second = ranking.split(" ")[1].toInt()

            rankingList.add(first to second)
        }

        rankingList.sortBy { it.first }

        var min = 0
        var result = 0

        rankingList.mapIndexed { index, ranking ->

            when (index == 0) {
                true -> {
                    result++
                    min = ranking.second
                }

                false -> {
                    if (ranking.second < min) {
                        result++
                        min = ranking.second
                    }
                }
            }

        }

        sb.append("$result\n")
    }

    print(sb)

}