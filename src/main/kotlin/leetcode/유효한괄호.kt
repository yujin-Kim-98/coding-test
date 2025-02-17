package leetcode

import java.util.*

/**
 * https://leetcode.com/problems/valid-parentheses/description/
 * LeetCode - 20. Valid Parentheses
 */
fun main() {

//    val s = "()"

//    val s = "()[]{}"

//    val s = "(]"

    val s = "([])"

    val result = Solution().isValid(s)

    println(result)

}

class Solution {

    val map = hashMapOf(
        '(' to ')',
        '{' to '}',
        '[' to ']',
    )

    fun isValid(s: String): Boolean {

        val stack = Stack<Char>()

        s.toCharArray().forEach {

            when (it == '(' || it == '{' || it == '[') {
                true -> stack.push(it)

                false -> {
                    if (stack.isEmpty() || map[stack.pop()] != it) {
                        return false
                    }
                }
            }

        }

        return stack.isEmpty()
    }

}