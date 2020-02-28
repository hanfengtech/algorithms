package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populatePathTree
import java.util.*

fun pathSum(root : TreeNode, sum : Int) : List<List<Int>> {
    var result = LinkedList<LinkedList<Int>>()
    var currentResult = LinkedList<Int>()

    pathSum(root, sum, currentResult, result)

    return result
}

fun pathSum(root : TreeNode?, sum : Int, currentResult : LinkedList<Int>, result : LinkedList<LinkedList<Int>>) {
    if (root == null) return

    currentResult.add(root.value)

    if (root.left == null && root.right == null && sum == root.value) {
        result.add(LinkedList(currentResult))
        currentResult.removeAt(currentResult.lastIndex)
        return
    }

    pathSum(root.left, sum - root.value, currentResult, result)
    pathSum(root.right, sum - root.value, currentResult, result)
    currentResult.removeAt(currentResult.lastIndex)
}

fun main() {
    print(pathSum(populatePathTree(), 22))
}