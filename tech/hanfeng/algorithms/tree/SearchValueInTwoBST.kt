package tech.hanfeng.algorithms.tree

import tech.hanfeng.algorithms.tree.utils.TreeNode
import tech.hanfeng.algorithms.tree.utils.populate123Tree

fun searchValueInTwoBST(root1 : TreeNode?, root2 : TreeNode?, target : Int) : Boolean {
    var cur1 = root1
    var cur2 = root2
    var found1 = false
    var found2 = false

    while (cur1 != null || cur2 != null) {
        if (!found1 && cur1 != null) {
            if (cur1.value == target) {
                found1 = true
                cur1 = null
            } else if (target < cur1.value) {
                cur1 = cur1.left
            } else {
                cur1 = cur1.right
            }
        }

        if (!found2 && cur2 != null) {
            if (cur2.value == target) {
                found2 = true
                cur2 = null
            } else if (target < cur2.value) {
                cur2 = cur2.left
            } else {
                cur2 = cur2.right
            }
        }
    }

    return found1 && found2
}

fun main() {
    var t1 = populate123Tree()
    var t2 = populate123Tree()
    println(searchValueInTwoBST(t1,t2, 3))
}