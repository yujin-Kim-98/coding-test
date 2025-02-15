package leetcode

/**
 * https://leetcode.com/problems/palindrome-number/description/
 * Easy - 9. Palindrome Number (팰린드롬 숫자)
 */
fun main() {

//    val x = 121

//    val x = -121

    val x = 10

    val result = Solution().isPalindrome(x)

    println(result)

}

class Solution {

    fun isPalindrome(x: Int): Boolean {

        val arr = x.toString().toCharArray()

        for (i in 0 until arr.size / 2) {
            val targetIndex = arr.lastIndex - i

            if (arr[i] != arr[targetIndex]) {
                return false
            }
        }

        return true

    }

}