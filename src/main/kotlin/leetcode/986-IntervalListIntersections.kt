package leetcode

fun main() {
    val firstList = arrayOf(
        intArrayOf(0, 2),
        intArrayOf(5, 10),
        intArrayOf(13, 23),
        intArrayOf(24, 25)
    )

    val secondList = arrayOf(
        intArrayOf(1, 5),
        intArrayOf(8, 12),
        intArrayOf(15, 24),
        intArrayOf(25, 26)
    )

    // Output: [[1,2],[5,5],[8,10],[15,23],[24,24],[25,25]]

    val result = intervalIntersection(firstList, secondList)

    result.forEach { print("[${it[0]}, ${it[1]}) ") }
}

fun intervalIntersection(
    firstList: Array<IntArray>,
    secondList: Array<IntArray>
): Array<IntArray> {
    if (firstList.isEmpty() || secondList.isEmpty()) return arrayOf()

    val result = mutableListOf<IntArray>()
    var i = 0
    var j = 0

    while (i < firstList.size && j < secondList.size) {
        val first = firstList[i]
        val second = secondList[j]

        val start = maxOf(first[0], second[0])
        val end = minOf(first[1], second[1])

        if (start <= end) {
            result.add(intArrayOf(start, end))
        }

        if (first[1] < second[1]) i++ else j++
    }

    return result.toTypedArray()
}