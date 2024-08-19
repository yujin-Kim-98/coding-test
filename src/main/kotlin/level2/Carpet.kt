package level2

// 프로그래머스 Level2 - 카펫
fun main() = with(System.`in`.bufferedReader()) {

    val brown = 24
    val yellow = 24

    val result = solution(brown, yellow)

    println("result : $result")

}

fun solution(
    brown: Int,
    yellow: Int
): IntArray {

    for (length in 1 .. yellow) {
        var width = 0

        if (yellow % length == 0) {
            width = yellow / length

            val totalLength = length + 2
            val totalWidth = width + 2

            if (totalLength * totalWidth - yellow == brown) {
                return intArrayOf(totalWidth, totalLength)
            }
        }
    }

    return intArrayOf()
}