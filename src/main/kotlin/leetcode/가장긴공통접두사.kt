package leetcode

import java.lang.StringBuilder

/**
 * https://leetcode.com/problems/longest-common-prefix/description/
 * LeetCode - 14. Longest Common Prefix (가장 긴 공통 접두사)
 */
fun main() {

    val strs = arrayOf(
        "flower","flow","flight"
    )

//    val strs = arrayOf(
//        "dog","racecar","car"
//    )

    val result = Solution().longestCommonPrefix(strs)

    println(result)

}

class Solution {

    fun longestCommonPrefix(strs: Array<String>): String {

        strs.sort()

        val first = strs.first()
        val last = strs.last()

        val prefix = StringBuilder()

        for (i in first.indices) {
            if (i < last.length && first[i] == last[i]) {
                prefix.append(first[i])
            } else {
                break
            }
        }

        return prefix.toString()

    }

}