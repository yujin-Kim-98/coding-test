package leetcode

import java.util.*

/**
 * LeetCode - 100. Same Tree
 * https://leetcode.com/problems/same-tree/description/?envType=problem-list-v2&envId=breadth-first-search
 */
fun main() {

    // EX1
//    val p = TreeNode(1)
//    p.left = TreeNode(2)
//    p.right = TreeNode(3)
//
//    val q = TreeNode(1)
//    q.left = TreeNode(2)
//    q.right = TreeNode(3)

    // EX2
//    val p = TreeNode(1)
//    p.left = TreeNode(2)
//
//    val q = TreeNode(1)
//    q.right = TreeNode(2)

    // EX3
    val p = TreeNode(1)
    p.left = TreeNode(2)
    p.right = TreeNode(1)

    val q = TreeNode(1)
    q.left = TreeNode(1)
    q.right = TreeNode(2)

    val result = Solution().isSameTree(p, q)

    println("result : $result")

}

class Solution {
    fun isSameTree(
        p: TreeNode?,
        q: TreeNode?
    ): Boolean {

        when {
            (p == null && q == null) -> return true
            (p == null || q == null) -> return false
            (p.`val` != q.`val`) -> return false
        }

        return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
    }
}

class TreeNode(
    var `val`: Int
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}