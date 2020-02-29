package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.*

fun countNodesS(root : TreeNode?) : Int {
   return if (root != null) (1 + countNodesS(root.left) + countNodesS(root.right)) else 0
}

fun countNodes(root : TreeNode?) : Int {
    var count = 0
    var h = getHeight(root)
    if (h < 0) return 0

    var cur = root
    while(cur != null) {
        val rightHight = getHeight(cur.right)
        if (rightHight == h - 1) {
            count += 1 shl h
            cur = cur.right
        } else {
            count += 1 shl (h - 1)
            cur = cur.left
        }
        --h
    }
    return count
}

fun getHeight(root: TreeNode?) : Int {
    if (root == null) return -1
    var height = -1
    var cur = root
    while(cur != null) {
        height++
        cur = cur.left
    }
    return height
}

fun countNodedsR(root : TreeNode?) : Int {
    var h = height(root)

    if (h < 0) return 0

    if (height(root!!.right) == h - 1) {
        return (1 shl h) + countNodedsR(root.right)
    } else {
        return (1 shl (h -1)) + countNodedsR(root.left)
    }
}

fun height(root : TreeNode?) : Int {
    return if (root == null) -1 else (1 + height(root.left))
}

fun main() {
    preorderPretty(populateCompleteTree())
    println(countNodesS(populateCompleteTree()))
    println(countNodes(populateCompleteTree()))
    println(countNodedsR(populateCompleteTree()))
}

