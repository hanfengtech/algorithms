package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populateTree

fun rightSideView(root : TreeNode?) : List<Int> {

    val result = ArrayList<Int>()

    fun rightView(curr : TreeNode?, result : ArrayList<Int>, currDepth : Int) {
        if (curr == null) return

        if (currDepth == result.size) {
            result.add(curr.value)
        }

        rightView(curr.right, result, currDepth + 1)
        rightView(curr.left, result, currDepth + 1)
    }

    rightView(root, result, 0)
    return result
}



fun main() {
    print(rightSideView(populateTree()))
}