package algorithm.greedy

import java.util.Scanner


// 백준 2839
// ex) 18킬로그램 -> 5킬로그램 3봉지, 3킬로그램 1봉지 = 총 4봉지
fun main() = with(System.`in`.bufferedReader()) {
    val input = readLine().toInt()

    for (i in (input / 5).downTo(0)) {
        val bag = (input - i * 5)

        if (bag % 3 != 0) {
            continue
        }

        println(i + bag / 3)
        return
    }

    println(-1)
}