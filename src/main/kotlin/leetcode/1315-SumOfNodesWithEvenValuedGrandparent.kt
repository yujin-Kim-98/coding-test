package leetcode

// https://leetcode.com/problems/sum-of-nodes-with-even-valued-grandparent/description/
fun main() {
    // EX1)
//    val root = TreeNode(6)
//
//    root.left = TreeNode(7)
//    root.left?.left = TreeNode(2)
//    root.left?.left?.left = TreeNode(9)
//
//    root.left?.right = TreeNode(7)
//    root.left?.right?.left = TreeNode(1)
//    root.left?.right?.right = TreeNode(4)
//
//    root.right = TreeNode(8)
//    root.right?.left = TreeNode(1)
//    root.right?.right = TreeNode(3)
//    root.right?.right?.right = TreeNode(5)

    // EX2)
    val root = TreeNode(1)

    val result = SumOfNodesWithEvenValuedGrandparent().sumEvenGrandparent(root)
    println("result : $result")

    /**
     * 조부모 (parent의 parent)가 짝수인 노드들의 합을 구하고 없다면 0 반환하라는 문제
     */
}

class SumOfNodesWithEvenValuedGrandparent {
    var result = 0

    fun sumEvenGrandparent(
        root: TreeNode?
    ) : Int {
        dfs(root, null, null)
        return result
    }

    fun dfs(
        node: TreeNode?,
        parent: Int?,
        grandparent: Int?
    ) {
        if (node == null) return
        grandparent?.let {
            if (it % 2 == 0) {
                result += node.`val`
            }
        }
        dfs(node.left, node.`val`, parent)
        dfs(node.right, node.`val`, parent)
    }
}

class TreeNode(
    var `val`: Int
) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}