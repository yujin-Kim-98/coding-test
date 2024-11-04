package level2

// 프로그래머스 Level2 - 예상대진표
fun main() = with(System.`in`.bufferedReader()) {

    val n = 8
    val a = 4
    val b = 7

    val result = solution(n, a, b)

    println("result : $result")
}

fun solution(
    n: Int,
    a: Int,
    b: Int
): Int {

    var first = a
    var second = b

    for (i in 1 .. n / 2) {

        first = (first / 2) + (first % 2)
        second = (second / 2) + (second % 2)

        if (first == second) {
            return i
        }
    }

    return 0
}