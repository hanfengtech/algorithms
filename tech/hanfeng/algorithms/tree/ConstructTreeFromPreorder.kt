package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.preorderPretty
import java.util.*

//[8,5,1,7,10,12]
fun bstFromPreorderR(preorder: IntArray): TreeNode? {

    var i = 0

    fun helper(preorder: IntArray, parentValue : Int = Int.MAX_VALUE) : TreeNode? {

        if (i == preorder.size || preorder[i] > parentValue) return null

        val curValue = preorder[i++]

        val tmp = TreeNode(curValue)
        tmp.left = helper(preorder, curValue)
        tmp.right = helper(preorder, parentValue)

        return tmp
    }

    return helper(preorder)
}

fun bstFromPreorder(preorder: IntArray) : TreeNode? {
    if (preorder.isEmpty()) return null

    val stack = LinkedList<TreeNode>()
    val root = TreeNode(preorder[0])
    stack.push(root)

    for (i in 1 until preorder.size) {
        val curValue = preorder[i]
        val cur = TreeNode(curValue)

        var top = stack.peek()

        while (stack.isNotEmpty() && stack.peek().value < curValue) {
            top = stack.pop()
        }

        if (curValue < top.value) {
            top.left = cur
        } else {
            top.right = cur
        }

        stack.push(cur)
    }

    return root
}


fun main() {
    preorderPretty(bstFromPreorder(intArrayOf(8,5,1,7,10,12)))
}