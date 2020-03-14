package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree
import tech.hanfeng.algorithms.tree.utils.preorderPretty

var count = 0

fun pathSumIII(root: TreeNode?, sum: Int): Int {
    if (root == null) return 0
    helper(root, sum, 0)
    pathSumIII(root.left, sum)
    pathSumIII(root.right, sum)
    return count
}

fun helper(root: TreeNode?, sum: Int, value: Int) {
    if (root == null) return

    val newSum = value + root.value
    if (newSum == sum)
        count++

    helper(root.left, sum, newSum)
    helper(root.right, sum, newSum)
}

fun main() {
    val tree = populate123Tree()
    preorderPretty(tree)
    println(pathSumIII(tree, 3))
}

