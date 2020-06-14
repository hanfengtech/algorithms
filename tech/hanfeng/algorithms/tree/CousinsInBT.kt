package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode


// Save the depth of the first node
var recordedDepth = -1
var isCousin = false

private fun dfs(node: TreeNode?, depth : Int, x : Int, y : Int) :Boolean {
    if (node == null) return false

    if (recordedDepth != -1 && depth > recordedDepth) {
        return false
    }


    if (node.value == x || node.value == y) {
        if (recordedDepth == -1) {
            recordedDepth = depth
        }
        return recordedDepth == depth
    }

    val left = dfs(node.left, depth + 1, x, y)
    val right = dfs(node.right, depth + 1, x, y)

    if (left && right && recordedDepth != depth + 1) {
        isCousin = true
    }
    return left || right
}


fun isCousins(root: TreeNode?, x: Int, y: Int): Boolean {
    dfs(root, 0, x, y)
    return isCousin
}
