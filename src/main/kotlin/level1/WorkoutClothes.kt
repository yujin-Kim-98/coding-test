package level1

// 프로그래머스 Level1 - 체육복
fun main() = with(System.`in`.bufferedReader()) {

//    val n = 5
//    val lost = intArrayOf(2, 4)
//    val reserve = intArrayOf(1, 3, 5)

//    val n = 5
//    val lost = intArrayOf(2, 4)
//    val reserve = intArrayOf(3)

//    val n = 3
//    val lost = intArrayOf(3)
//    val reserve = intArrayOf(1)

    val n = 5
    val lost = intArrayOf(5, 3)
    val reserve = intArrayOf(4, 2)

    val result = solution(n, lost, reserve)

    println("result : $result")

}

fun solution(
    n: Int,
    lost: IntArray,
    reserve: IntArray
): Int {

    var result = n - lost.size + reserve.count { lost.contains(it) }
    val reserves = reserve.filterNot { lost.contains(it) }.sorted().toMutableList()
    val losts = lost.filterNot { reserve.contains(it) }

    losts.sorted().map { x ->
        reserves.find {
            (it - 1 .. it + 1).contains(x)
        }?.let {
            result++
            reserves.remove(it)
        }
    }

    return result
}