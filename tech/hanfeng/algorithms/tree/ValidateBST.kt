package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty



// In-order travels and remember the previous node value
fun isValidateBST(root : TreeNode?) : Boolean {

    if (root != null && root.left == null && root.right == null) return true

    var prevVal = Integer.MIN_VALUE.toLong() - 1

    fun helper(root: TreeNode?) : Boolean {
        if (root == null) return true

        if (!helper(root.left)) return false

        println("prevVal: $prevVal Node: ${root.value}")
        // if left child which is the prev node value greater than curr value, return false
        if (prevVal >= root.value) return false

        prevVal = root.value.toLong()

        return helper(root.right)
    }

    return helper(root)
}

fun main() {
   // val tree = populateTree()
   // println(isValidateBST(tree))


    var node = TreeNode(5)
    node.left = TreeNode(2)
    node.left!!.left = TreeNode(1)
    node.left!!.right = TreeNode(3)
    node.right = TreeNode(6)
    node.right!!.left = TreeNode(4)
    node.right!!.right = TreeNode(7)

    preorderPretty(node)
    println(isValidateBST(node))

    node = TreeNode(5)
    node.left = TreeNode(1)
    node.right = TreeNode(6)
    node.right!!.left = TreeNode(7)
    node.right!!.right = TreeNode(8)

    preorderPretty(node)
    println(isValidateBST(node))


    node = TreeNode(-2147483648)
    node.right = TreeNode(Integer.MAX_VALUE)

    println(isValidateBST(node))


}