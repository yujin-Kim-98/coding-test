package leetcode

/**
 * https://leetcode.com/problems/roman-to-integer/description/
 * Easy - 13. Roman to Integer (로마자에서 정수로)
 */
fun main() {

    val s = "III"

//    val s = "LVIII"

//    val s = "MCMXCIV"

    val result = Solution().romanToInt(s)

    println(result)

}

class Solution {

    val romanMap = hashMapOf<Char, Int>(
        'I' to 1,
        'V' to 5,
        'X' to 10,
        'L' to 50,
        'C' to 100,
        'D' to 500,
        'M' to 1000,
    )

    fun romanToInt(s: String): Int {

        val nums = s.toCharArray().map {
            romanMap[it] ?: 0
        }

        var prevNum = 0
        var sum = 0

        nums.forEach {

            if(it > prevNum) {
                sum -= prevNum
                sum += it - prevNum
            } else {
                sum += it
            }

            prevNum = it

        }


        return sum
    }

}