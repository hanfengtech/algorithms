package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populatePathTree

fun closestValue(root: TreeNode, target: Double): Int {
    var currNode : TreeNode? = root
    var currValue = root.value
    var closest = currValue

    while (currNode != null) {
        currValue = currNode.value
        val diff = currValue - target
        println(diff)
        if (Math.abs(currValue - target)
                      <  Math.abs(closest - target) ) {
            closest = currValue
        }
        currNode = if (target < currNode.value) currNode.left else currNode.right
    }

    return closest
}

fun main() {
    print(closestValue(populatePathTree(), 23.0))
}
