package algorithm.stack

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val cnt = readLine().toInt()
    val result = mutableListOf<String>()

    for (i in 1 .. cnt) {
        val ps = readLine().toCharArray()

        result.add(solution(ps))
    }

    println(result.joinToString("\n"))

}

fun solution(
    ps: CharArray
): String {

    val stack = Stack<Char>()

    ps.map {

        when (it.toString().equals("(")) {
            true -> stack.push(it)
            false -> {
                if (stack.isEmpty()) {
                    return "NO"
                } else {
                    if (stack.peek().toString().equals("(")) {
                        stack.pop()
                    } else {
                        return "NO"
                    }
                }
            }
        }

    }

    if (stack.isNotEmpty()) {
        return "NO"
    }

    return "YES"

}