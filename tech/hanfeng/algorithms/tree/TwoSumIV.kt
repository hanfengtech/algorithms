package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode

fun findTarget(root: TreeNode?, k: Int): Boolean {

    var list = ArrayList<Int>()
    inOrder(root, list)

    var l = 0
    var r = list.size - 1

    while (l < r) {
        val sum = list[l] + list[r]
        if (sum == k) {
            return true
        } else if (sum < k) {
            l++
        } else {
            r--
        }
    }
    return false
}

fun inOrder(root: TreeNode? , list : ArrayList<Int>) {
    if (root == null) return
    inOrder(root.left)
    list.add(root.value)
    inOrder(root.right)
}