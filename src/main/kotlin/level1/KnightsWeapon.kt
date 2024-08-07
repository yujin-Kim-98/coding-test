package level1

import kotlin.math.sqrt

fun main() = with(System.`in`.bufferedReader()) {

    val number = 10
    val limit = 3
    val power = 2

    val result = solution(number, limit, power)

    println("result: $result")

}

fun solution(
    number: Int,
    limit: Int,
    power: Int
): Int {

    var sum = 0

    for (i in 1 .. number) {

        val divisorCount = getDivisorCount(i)

        val weight = when (divisorCount > limit) {
            true -> power
            false -> divisorCount
        }

        sum += weight

    }

    return sum
}

// 약수 구하기
fun getDivisorCount(
    number: Int
): Int {

    val sqrt = sqrt(number.toDouble())
    val result = mutableListOf<Int>()

    for (i in 1 .. sqrt.toInt()) {
        if (number % i == 0) {
            result.add(i)

            if (number / i != i) {
                result.add(number / i)
            }
        }
    }

    return result.size

}