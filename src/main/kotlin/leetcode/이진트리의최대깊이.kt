package leetcode

import java.util.*

/**
 * https://leetcode.com/explore/featured/card/top-interview-questions-easy/94/trees/555/
 * LeetCode - Top Interview Questions - Maximum Depth of Binary Tree (Trees)
 */
fun main() {

    val root = TreeNode(3)

    root.left = TreeNode(9)
    root.right = TreeNode(20)

    root.right?.left = TreeNode(15)
    root.right?.right = TreeNode(7)

    println(Solution().maxDepth(root))

}

class TreeNode(
    var `val`: Int
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {

    // DFS
    fun maxDepth(root: TreeNode?): Int {

        when (root == null) {
            true -> return 0
            false -> return 1 + maxOf(maxDepth(root.left), maxDepth(root.right))
        }

    }

}
