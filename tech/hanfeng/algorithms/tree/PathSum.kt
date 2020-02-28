package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

fun hasPathSumR(root : TreeNode?, sum : Int) : Boolean {
    if (root == null) return false

    val remain = sum - root.value
    if (root.left == null && root.right == null && remain == 0) return true
    return hasPathSumR(root.left, remain) || hasPathSumR(root.right, remain)
}

fun hasPathSum(root: TreeNode, sum : Int) : Boolean {

    val nodes = LinkedList<TreeNode>()
    val values = LinkedList<Int>()
    nodes.add(root)
    values.add(root.value)

    while(nodes.isNotEmpty()) {
        var curr = nodes.poll()
        val sumValue = values.poll()

        if (curr.left == null && curr.right == null && sumValue == sum) {
            return true
        }

        if (curr.left != null) {
            nodes.add(curr.left!!)
            values.add(sumValue + curr.left!!.value)
        }

        if (curr.right != null) {
            nodes.add(curr.right!!)
            values.add(sumValue + curr.right!!.value)
        }
    }

    return false
}

fun main() {
    val tree = populateTree()
    preorderPretty(tree)
    val sum = 44+17+8
    println(hasPathSumR(tree, sum))
    println(hasPathSum(tree, sum))
}