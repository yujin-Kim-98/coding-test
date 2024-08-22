package level1

// 프로그래머스 Level1 - 실패율
fun main() = with(System.`in`.bufferedReader()) {

    val N = 5
    val stages = intArrayOf(2, 1, 2, 4, 2, 4, 3, 3)

    val result = solution(N, stages)

    println("result : ${result.map { it }}")

}

fun solution(
    N: Int,
    stages: IntArray
): IntArray {

    var userCount = stages.size

    val failureRateMap = mutableMapOf<Int, Double>()
    for (i in 1 .. N) {
        val stageCount = stages.filter {
            it == i
        }.count()

        val failureRate = when (userCount == 0) {
            true -> 0.0
            false -> stageCount.toDouble() / userCount
        }
        failureRateMap.put(i, failureRate)

        userCount -= stageCount
    }

    return failureRateMap
        .toList()
        .sortedByDescending { (key, value) -> value }
        .map { it.first }
        .toIntArray()
}