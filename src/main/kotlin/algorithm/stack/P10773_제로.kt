package algorithm.stack

import java.util.*

fun main() = with(System.`in`.bufferedReader()) {

    val cnt = readLine().toInt()

    val stack = Stack<Int>()

    for (i in 0 until cnt) {
        val number = readLine().toInt()

        when (number == 0) {
            true -> stack.pop()
            false -> stack.push(number)
        }
    }

    println(stack.sum())

}