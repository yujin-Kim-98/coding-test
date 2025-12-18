package leetcode

// LeetCode - 1413. Minimum Value to Get Positive Step by Step Sum
fun main() {
//    val nums = intArrayOf(-3, 2, -3, 4, 2)
    val nums = intArrayOf(1, 2)
//    val nums = intArrayOf(1, -2, -3)
//    val nums = intArrayOf(2, 3, 5, -5, -1)

    val result = minStartValue(nums)
    println("result : $result")
}

fun minStartValue(
    nums: IntArray
): Int {
    var startValue = 1
    while (!check(nums, startValue)) {
        startValue++
    }
    return startValue
}

fun check(
    nums: IntArray,
    value: Int
): Boolean {
    var startValue = value
    for (i in 0 until nums.size) {
        startValue += nums[i]
        if (startValue < 1) {
            return false
        }
    }
    return true
}
