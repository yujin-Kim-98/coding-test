package leetcode

// https://leetcode.com/problems/lexicographically-smallest-string-after-a-swap/description/
fun main() {
//    val s = "45320"
//    val s = "001"
    val s = "5731"

    // output : 43520
    // output : 001

    val result = getSmallestString(s)
    println("result : $result")
}

fun getSmallestString(
    s: String
): String {

    for (i in 0 until s.length - 1) {
        val first = s[i].digitToInt()
        val second = s[i + 1].digitToInt()

        if (check(first, second) && first > second) {
            val arr = s.toCharArray()
            val tmp = arr[i]
            arr[i] = arr[i + 1]
            arr[i + 1] = tmp
            return String(arr)
        }
    }

    return s
}

fun check(
    first: Int,
    second: Int
): Boolean {
    return when (first % 2) {
        0 -> second % 2 == 0
        else -> second % 2 == 1
    }
}