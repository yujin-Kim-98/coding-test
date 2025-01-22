package algorithm.DFSBFS

import java.io.BufferedReader
import java.io.InputStreamReader
import java.util.*

// 백준 1260 - DFS와 BFS

private var arr = emptyArray<MutableList<Int>>()
private var visited = emptyArray<Boolean>()

fun main() = with(BufferedReader(InputStreamReader(System.`in`))) {

    var st = StringTokenizer(readLine())

    val N = st.nextToken().toInt()
    val M = st.nextToken().toInt()
    val start = st.nextToken().toInt()

    arr = Array(N + 1, { mutableListOf() })
    visited = Array(N + 1, { false })

    for (i in 0 until M) {
        st = StringTokenizer(readLine())

        val first = st.nextToken().toInt()
        val second = st.nextToken().toInt()

        arr[first].add(second)
        arr[second].add(first)
    }

    arr.map {
        it.sort()
    }

    DFS(start, arr[start])

    println()

    visited = Array(N + 1, { false })

    BFS(start)

}

fun DFS(
    target: Int,
    list: List<Int>
) {

    if (!visited[target]) {
        print("$target ")
        list.map {
            visited[target] = true
            DFS(it, arr[it])
        }
    }

}

fun BFS(
    target: Int
) {

    val queue: Queue<Int> = LinkedList()
    queue.offer(target)
    visited[target] = true

    while (!queue.isEmpty()) {
        val num = queue.poll()
        print("$num ")

        arr[num].map {
            if (!visited[it]) {
                queue.offer(it)
                visited[it] = true
            }
        }
    }

}