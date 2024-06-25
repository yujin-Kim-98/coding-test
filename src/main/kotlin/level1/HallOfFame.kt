package level1

// 프로그래머스 Level1 - 명예의 전당(1)
fun main() = with(System.`in`.bufferedReader()) {

    val k = 4
    val scores = intArrayOf(0, 300, 40, 300, 20, 70, 150, 50, 500, 1000)

    val result = solution(k, scores)

    println("result: $result")
}

// 프로그래머스에서 min(), max() 함수가 동작 안함. minOf { it }, maxOf { it } 사용 할 것ㅠ
fun solution(
    k: Int,
    scores: IntArray
): IntArray {

    val hallOfFame = mutableListOf<Int>()

    val result = mutableListOf<Int>()

    for (score in scores) {

        if (hallOfFame.size >= k) {
            if (hallOfFame.minOf { it } <= score) {
                hallOfFame.add(score)
                hallOfFame.remove(hallOfFame.minOf { it })
            }
        } else {
            hallOfFame.add(score)
        }

        result.add(hallOfFame.minOf { it })
        result.sorted()

    }

    return result.toIntArray()

}