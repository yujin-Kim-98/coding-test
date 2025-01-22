package algorithm.DFSBFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 백준 2606 - 바이러스

private var arr = emptyArray<MutableList<Int>>()
private var visited = emptyArray<Boolean>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    val node = readLine().toInt()
    val edge = readLine().toInt()

    arr = Array(node + 1, { mutableListOf<Int>() })
    visited = Array(node + 1, { false })

    for (i in 0 until edge) {
        val st = StringTokenizer(readLine())

        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        arr[first].add(second)
        arr[second].add(first)
    }

    DFS2(1, arr[1])

    val result = visited.count { it == true } - 1

    println(result)

}

fun DFS2(
    target: Int,
    list: List<Int>
) {

    if (!visited[target]) {
        visited[target] = true
        list.map {
            DFS2(it, arr[it])
        }
    }

}