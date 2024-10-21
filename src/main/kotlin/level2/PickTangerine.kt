package level2

// 프로그래머스 Level2 - 귤 고르기
fun main() = with(System.`in`.bufferedReader()) {

    val k = 2
//    val tangerine = intArrayOf(1, 3, 2, 5, 4, 5, 2, 3)
    val tangerine = intArrayOf(1, 1, 1, 1, 2, 2, 2, 3)

    val result = solution2(k, tangerine)

    println("result: $result")

}

fun solution2(
    k: Int,
    tangerine: IntArray
): Int {

    val tangerineGroup = tangerine.groupBy {
        it
    }.mapValues {
        it.value.size
    }.toList().sortedByDescending { it.second }.toMap()

    var totalCount = 0
    var result = 0

    tangerineGroup.map {
        if (totalCount < k) {
            totalCount += it.value
            result++
        }
    }

    return result
}