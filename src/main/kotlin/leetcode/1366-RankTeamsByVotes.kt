package leetcode

import kotlin.math.max

/**
 * LeetCode - 1366. Rank Teams by Votes
 * https://leetcode.com/problems/rank-teams-by-votes/description/
 */
fun main() {

    // EX1)
    val votes = arrayOf("ABC","ACB","ABC","ACB","ACB")

    // EX2)
//    val votes = arrayOf("WXYZ","XYZW")

    // EX3)
//    val votes = arrayOf("ZMNAGUEDSJYLBOPHRQICWFXTVK")

    val result = Solution().rankTeams(votes)

    println("result : $result")

}

class Solution {
    fun rankTeams(
        votes: Array<String>
    ): String {

        if (votes.size == 1) {
            return votes[0]
        }

        val map = mutableMapOf<Char, IntArray>()

        for (team in votes[0]) {
            map[team] = IntArray(votes[0].length)
        }

        for (vote in votes) {
            for ((index, team) in vote.withIndex()) {
                map[team]!![index] += 1
            }
        }

        val sortedTeams = map.keys.sortedWith { a, b ->
            val rankA = map[a]!!
            val rankB = map[b]!!

            for (i in 0 until votes[0].length) {
                if (rankA[i] != rankB[i]) {
                    return@sortedWith rankB[i] - rankA[i]
                }
            }
            a - b
        }


        return sortedTeams.joinToString("")
    }
}