package level1

import java.util.LinkedList

// 프로그래머스 Level1 - 가장 가까운 같은 글자
fun main() = with(System.`in`.bufferedReader()) {

    val s = "foobar"

    val result = solution(s)

    println("result : $result")

}

fun solution(
    s: String
): IntArray {
    val sArr = s.toCharArray()

    return sArr.withIndex().map { (index, char) ->
        var targetIndex = sArr.sliceArray(IntRange(0, index - 1)).indexOfLast {
            it == char
        }

        if (targetIndex != -1) {
            targetIndex = index - targetIndex
        }
        targetIndex
    }.toIntArray()
}