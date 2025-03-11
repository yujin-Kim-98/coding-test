package level2

import java.util.*
import kotlin.collections.ArrayDeque

fun main() {

    val n = 9
    val wires = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(2, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 6),
        intArrayOf(4, 7),
        intArrayOf(7, 8),
        intArrayOf(7, 9)
    )

    val result = Solution().solution(n, wires)

    println("result : $result")

}

class Solution {

    private val map = mutableMapOf<Int, MutableList<Int>>()

    fun solution(
        n: Int,
        wires: Array<IntArray>
    ): Int {

        var result = n

        for (i in 1 .. n) {
            map.put(i, mutableListOf())
        }

        for (i in 0 until wires.size) {
            map[wires[i][0]]?.add(wires[i][1])
            map[wires[i][1]]?.add(wires[i][0])
        }

        // 간선 하나씩 제거하면서 계산
        for (wire in wires) {

            map[wire[0]]?.remove(wire[1])
            map[wire[1]]?.remove(wire[0])

            val count = BFS(wire[0], n)
            val remainCount = n - count
            val diff = Math.abs(count - remainCount)

            if (result > diff) {
                result = diff
            }

            map[wire[0]]?.add(wire[1])
            map[wire[1]]?.add(wire[0])

        }

        return result
    }

    private fun BFS(
        number: Int,
        n: Int
    ): Int {

        val visited = Array(n + 1) { false }
        val queue = LinkedList<Int>()

        queue.add(number)
        visited[number] = true

        while (!queue.isEmpty()) {
            val node = queue.pop()

            for (n in map[node] ?: listOf()) {
                if (!visited[n]) {
                    queue.add(n)
                    visited[n] = true
                }
            }
        }

        return visited.count { it == true }

    }

}