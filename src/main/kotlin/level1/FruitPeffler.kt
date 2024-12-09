package level1

fun main() = with(System.`in`.bufferedReader()) {

    val k = 3
    val m = 4
    val score = intArrayOf(1, 2, 3, 1, 2, 3, 1)

//    val k = 4
//    val m = 3
//    val score = intArrayOf(4, 1, 2, 2, 4, 4, 4, 4, 1, 2, 4, 2)

    val result = solution(k, m, score)

    println("result : $result")

}

fun solution(
    k: Int,
    m: Int,
    score: IntArray
): Int {

    return score
        .sortedDescending()
        .chunked(m)
        .filter { it.size == m }
        .map { it.minOf { it } * m }
        .sum()
}