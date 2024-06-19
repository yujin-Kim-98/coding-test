package level1

// 프로그래머스 Level1 추억 점수
fun main() {

    val name = arrayOf("may", "kein", "kain", "radi")
    val yearning = intArrayOf(5, 10, 1, 3)
    val photo = arrayOf(
        arrayOf("may", "kein", "kain", "radi"),
        arrayOf("may", "kein", "brin", "deny"),
        arrayOf("kon", "kain", "may", "coni")
    )

    val result = solution(name, yearning, photo)

    println("result: $result")

}

// 내 풀이
fun solution(
    name: Array<String>,
    yearning: IntArray,
    photo: Array<Array<String>>
): IntArray {

    val answer = ArrayList<Int>()

    val memories: Array<Pair<String, Int>> = name.mapIndexed { index, n ->
        Pair(n, yearning[index])
    }.toTypedArray()

    for (row in photo) {
        // 사진들
        var score = 0
        for (column in row) {
            // 이름들
            memories.find { it.first == column }?.let {
                score += it.second
            }
        }

        answer.add(score)
    }
    return answer.toIntArray()
}

// 다른 멋찐 코드👍
// zip은 서로 다른 array를 같은 인덱스끼리 묶어주는 친구
fun solution2(
    names: Array<String>,
    yearnings: IntArray,
    photoes: Array<Array<String>>
): IntArray {

    val map = names.zip(yearnings.toTypedArray()).toMap()
    return photoes.map { photo -> photo.sumOf { map[it] ?: 0 } }.toIntArray()

}