package level2

// 프로그래머스 Level2 - 행렬의 곱셈
fun main() = with(System.`in`.bufferedReader()) {

    val arr1 = arrayOf(
        intArrayOf(2, 3, 2, 4),
        intArrayOf(4, 2, 4, 5),
        intArrayOf(3, 1, 4, 6),
    )

    val arr2 = arrayOf(
        intArrayOf(5, 4, 3),
        intArrayOf(2, 4, 1),
        intArrayOf(3, 1, 1),
        intArrayOf(3, 1, 1),
    )

    val result = solution(arr1, arr2)

    println("result : ${result.map { it }}")

}

fun solution(
    arr1: Array<IntArray>,
    arr2: Array<IntArray>
): Array<IntArray> {

    return  arr1.mapIndexed { i, _ ->
                arr2[0].mapIndexed { k, _ ->
                    arr1[i].mapIndexed { j, _ ->
                        arr1[i][j] * arr2[j][k]
                    }.sumOf { it }
                }.toIntArray()
            }.toTypedArray()
}